abstract class A<RT extends A> {
    protected abstract RT doStuff();
}

class B extends A<B> {
    // doStuff must return a B
}

class C extends A<C> {
    // doStuff must return a C
}