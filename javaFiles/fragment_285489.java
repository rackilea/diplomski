// Foo is the superclass
private class FooAdapter {
    private Foo foo;

    public FooAdapter(Foo foo) {
        this.foo = foo;
    }

    public void doThis() {
        return foo.doThis();
    }
}