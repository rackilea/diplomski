static <D,A> TestMethod<D,A> method(
    Class<D> declarer, String name, Class<A> argType) throws ReflectiveOperationException {

    Method method = declarer.getDeclaredMethod(name, argType);
    method.setAccessible(true);
    return MethodHandleProxies.asInterfaceInstance(
        TestMethod.class, MethodHandles.lookup().unreflect(method));
}