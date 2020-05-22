public abstract class Foo {
    public int foo() {
        bar();
        closingMethod();
        return baz();
    }
    protected abstract void bar();
    protected abstract int baz();
}