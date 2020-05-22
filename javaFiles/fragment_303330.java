SomeObject foo;

public void doSomething(SomeObject bar) {
    bar.whatever();
    bar = new SomeObject();
    bar.someOtherMethod();
}

public void doStuff() {
    foo = new SomeObject();
    doSomething(foo);
}