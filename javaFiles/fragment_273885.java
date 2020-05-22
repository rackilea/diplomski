// #1
public final class MyStaticClass {
    static {
        a = new A();
        b = new B(MyStaticClass.a);
    }

    private static final A a;
    private static final B b;
}