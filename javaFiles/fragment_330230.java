public final class SynchronizedFactory {
    private SynchronizedFactory() {}

    public static <T> T makeSynchronized(Class<T> ifCls, T object) {
        return ifCls.cast(Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                new Class<?>[] {ifCls},
                new Handler<T>(object)));
    }

    private static class Handler<T> implements InvocationHandler {
        private final T object;

        Handler(T object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method,
                Object[] args) throws Throwable {
            synchronized (object) {
                return method.invoke(object, args);
            }
        }
    }
}