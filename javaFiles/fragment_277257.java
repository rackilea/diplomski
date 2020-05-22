package packageA;

import packageB.B;

public class A {
    private B myB;

    public A() {
        this.myB = new B();
    }

    public void doSomethingThatUsesB() {
        System.out.println("Doing things with myB");
        this.myB.doSomething();
    }
}