// #3
public final class MyStaticClass {
    private static final A a;
    private static final B b;

    static {
        a = new A();
        b = new B(a);
    }
}