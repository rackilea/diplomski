public abstract class A {
    protected A() {
        this(0);
    }
    private A(int a) {
        // not accessible to anyone but members of A
        // the point is not to prevent instantiation, but to restrict access
    }
}