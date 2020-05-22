class Foo {
    public Foo() {}

    public Foo a () { /* do something and */ return this; }
    public Foo b () { /* do something else and */ return this; }
}

new Foo().a().b().a();