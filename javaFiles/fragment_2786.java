class A {
    public A foo() {
        return this;
    }
    @SuppressWarnings("unchecked")
    public <T extends A> T as(Class<T> clazz) {
        return (T) this;
    }
}

class B extends A  {}