public interface TestMethod<D,A> {
    void invoke(D d, A a) throws Throwable;
}
static <D,A> TestMethod<D,A> method(
    Class<D> declarer, String name, Class<A> argType) throws ReflectiveOperationException {

    Method method = declarer.getDeclaredMethod(name, argType);
    method.setAccessible(true);
    return (d,a) -> {
        try {
            method.invoke(d, a);
        } catch(InvocationTargetException ex) {
            throw ex.getTargetException();
        }
    };
}