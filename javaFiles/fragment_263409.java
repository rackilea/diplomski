class foo<T> {

    protected T[] arr;

    @SuppressWarnings("unchecked")
    public foo(Class<T> componentType) {
        arr = (T[]) Array.newInstance(componentType, 5);
    }
}