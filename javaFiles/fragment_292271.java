public class Foo {

    private int a = someMethod();
    private int b = 42;

    public Foo() {
    }

    private int someMethod() {
        return this.b;
    }
}