class UnixFoo extends Foo {

    private Foo foo;

    public UnixFoo(Foo foo) {
        this.foo = foo;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Override
    public Date getFoo() {
        return foo.getFoo();
    }

    // other getters
}