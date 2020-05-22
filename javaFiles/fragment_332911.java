class Test<E extends DeepCloneable> {

    public void testDeepClone(E arg) {
        E e = (E) arg.deepClone();
    }
}