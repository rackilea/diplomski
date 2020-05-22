class A {}
class B extends A {}

class AWrapper<T extends A> {
    public void wrap(T obj) {}
}

class BWrapper<T extends B> extends AWrapper<T> {
    @Override
    public void wrap(T obj) {}
}