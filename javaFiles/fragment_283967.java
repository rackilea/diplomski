class Foo {
    protected void method() {}
}

class FooWrapper extends Foo {

    protected void method() {
        super.method();
    }
}