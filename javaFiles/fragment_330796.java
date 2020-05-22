class Something1 { }

public interface MyInterface<E extends Something1> {
    public void meth1(MyClass1<E> x);
}

// and I have a subclass whose superclass implements the above interface:
public class MyClass2<E extends Something1>
    extends Superclass<E> {

    public MyClass2() { }

    public void meth1(MyClass1<E> x) { }
}

// superclass:
public abstract class Superclass<E extends Something1> implements
        MyInterface<E> {
    MyClass1<E> x;
    protected E y;

    public Superclass() { }
}

// MyClass1:
public abstract class MyClass1<E extends Something1> {

    public MyClass1() {

    }
}