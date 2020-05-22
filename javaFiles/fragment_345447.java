public class FooImpl implements Foo {
    private Bar bar; // implementation will be injected by Spring

    public FooImpl() { }
    public FooImpl(Bar bar) { this.bar = bar; }

    public void setBar(Bar bar) { this.bar = bar; }
    public Bar getBar() { return this.bar; }

    public void doFoo() {
        getBar().doBar();
    }
}