class A {
    void doAStuff() {
        System.out.println("A-method");
    }
}

class B {
    void doBStuff() {
        System.out.println("B-method");
    }
}

// Wraps an A and a B object.
class C {
    A aObj;
    B bObj;

    void doAStuff() {
        aObj.doAStuff();
    }

    void doBStuff() {
        bObj.doBStuff();
    }
}