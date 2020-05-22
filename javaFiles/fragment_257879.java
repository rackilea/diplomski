public final class MyMethod<T> {

    private final Method method;

    public MyMethod(Method method) {
        this.method = method;
    }

    public T invoke(Object o, Object... args) throws IllegalAccessException, InvocationTargetException {
        return (T) method.invoke(o, args);      // Unchecked cast
    }
}