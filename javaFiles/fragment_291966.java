public class Wrapper<T> implements InvocationHandler {
    private final T delegate;

    public Wrapper(T delegate) {
        this.delegate = delegate;
    }

    public static <T, I> I proxy(T delegate, Class<I> facade) {
        return (I) Proxy.newProxyInstance(
            facade.getClassLoader(),
            new Class[] { facade },
            new Wrapper(delegate)
        );
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return delegate.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes()).invoke(delegate, args);
    }
}