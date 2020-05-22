class NiceFoo implements Bar {
    private final Foo delegate;

    NiceFoo(final Foo delegate) {
        this.delegate = delegate;
    }

    @Override
    void bar() {
        delegate.bar();
    }
}