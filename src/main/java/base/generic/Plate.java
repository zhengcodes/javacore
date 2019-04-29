package base.generic;

public class Plate<T> {
    private T item;

    public Plate(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    public void set(T item) {
        this.item = item;
    }

    static class Fruit {
    }

    ;

    static class Apple extends Fruit {
    }

    public static void main(String[] args) {
        /**
         * PECS（Producer Extends Consumer Super）原则：
         * 1、频繁往外读取内容的，适合用上界Extends。
         * 2、经常往里插入的，适合用下界Super。
         */
        Plate<? extends Fruit> p = new Plate<>(new Apple());
        //不能存入任何元素
        /*p.setItem(new Apple());//Error*/
        //读取出来的东西只能存放在Fruit或它的基类里。
        Fruit newFruit1=p.get();
        Object newFruit2=p.get();


        Plate<? super Fruit> p2=new Plate<>(new Fruit());
        //存入元素正常
        p2.set(new Fruit());
        p2.set(new Apple());
        //读取出来的东西只能存放在Object类里。
        /*Apple newFruit3=p.get();//Error
        Fruit newFruit1=p.get();//Error*/
        p2.set(new Apple());
        Object newFruit3=p2.get();
    }
}
