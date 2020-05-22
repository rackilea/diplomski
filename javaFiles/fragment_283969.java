public class Foo {

    protected void method() {
        System.out.println("In Foo.method()");
    }
}

public class DelegateFoo extends Foo {

    public void method() {
        super.method();
    }
}

public class FooWrapper extends Foo {

    private DelegateFoo foo;

    public FooWrapper(DelegateFoo foo) {
        this.foo = foo;
    }

    public void method() {
        foo.method();
        /* extra logic here */
    }
}