package one;

import one.two.Foo;

public class Bar {

    void makeCall() {
        new Foo().doSomething();
    }

    public static void main(String[] args) {
        new Bar().makeCall();
    }

}