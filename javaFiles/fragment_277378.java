public final class ProxyBuilder {

    public static Connection tracingConnection(Connection connection) {
        return createProxy(connection, new ConnectionProxy(connection));
    }

    static <T> T createProxy(T anObject, InvocationHandler invocationHandler) {
        return createProxy(anObject, invocationHandler, anObject.getClass().getInterfaces());
    }

    static <T> T createProxy(T anObject, InvocationHandler invocationHandler, Class... forcedInterfaces) {
        return (T) Proxy.newProxyInstance(
            anObject.getClass().getClassLoader(),
            forcedInterfaces,
            invocationHandler);
        }
}