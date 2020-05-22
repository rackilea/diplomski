// #2
public final class MyStaticClass {
    static {
        b = new B(a = new A());
    }

    private static final A a;
    private static final B b;
}