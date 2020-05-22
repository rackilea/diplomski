import java.lang.reflect.Proxy;

public static <I> I restrictToInterface(final I instance, Class<I> publicInterface) {
    Object proxy = Proxy.newProxyInstance(
        publicInterface.getClassLoader(), 
        new Class<?>[] {publicInterface}, 
        new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(instance, args);
            }
        }
    );
    return publicInterface.cast(proxy);
}