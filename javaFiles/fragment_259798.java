class Foo {
    int bar;

    public Foo() {
        this.bar = 123;
        // ...
    }

    public Foo(int bar) {
        this.bar = 123;

        this.bar = bar;
        // ...
    }
}