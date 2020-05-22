public interface Recur<T extends Recur<T>> {
    T foo();
}

class A implements Recur<B> {
    @Override
    public B foo() {
        return new B();
    }
}

class B implements Recur<A> {
    @Override
    public A foo() {
        return new A();
    }
}