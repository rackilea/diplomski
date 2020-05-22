class A {
    public A() {
        System.out.println(getClass());
    }
}

class B extends A {
}

...

A a = new B(); // Prints B in the A constructor