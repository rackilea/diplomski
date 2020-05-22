package my.thirdparty.application;

public class Bar {
    Foo foo = new Foo();

    public void doSomething() {
        someMethod();
        bar();
        anotherMethod();
    }

    private void someMethod() {
        foo.blah();
        foo.foo();
        foo.zot();
    }

    private void bar() {
        foo.blah();
        // This is the only call we want to intercept, 'foo' called by 'bar'
        foo.foo();
        foo.zot();
        anotherMethod();
    }

    private void anotherMethod() {
        foo.blah();
        foo.foo();
        foo.zot();
    }
}