abstract class A {
    void doStuff();
}

class Y extends A {
    @Override
    void doStuff() {
        // Y specific implementation
    }
}

class X extends A {
    @Override
    void doStuff() {
        // X specific implementation
    }
}