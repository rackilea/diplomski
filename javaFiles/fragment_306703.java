abstract class A {
    abstract void doStuff();
}

abstract class B extends A {
    // This is fine since B is abstract
}

class C extends A {
    // This is an error since doStuff() isn't implemented
}