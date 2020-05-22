interface FooInterface {
    public void doSomething();
}

class Foo implements FooInterface {
    public void doSomething() { }
}

interface BarInterface {
    public void myMethod(FooInterface f);
}

class Bar implements BarInterface {
    public void myMethod(Foo f) { }
    //                   ^----------------- Note
}