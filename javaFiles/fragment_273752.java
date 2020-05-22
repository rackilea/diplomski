class A<T extends A<?>> {

    @SuppressWarnings("unchecked")
    public T test() {
        return (T) this;
    }
}