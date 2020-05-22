final class MethodSpy<T>
        implements Function<Object[], T>, Supplier<T> {

    private static final Object[] emptyObjectArray = {};

    private final Object instance;
    private final Method method;

    private MethodSpy(final Object instance, final Method method) {
        this.instance = instance;
        this.method = method;
    }

    static <T> MethodSpy<T> spyMethod(final Class<?> declaringClass, final Object instance, final String methodName, final Class<?>... parameterTypes)
            throws NoSuchMethodException {
        final Method method = declaringClass.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return new MethodSpy<>(instance, method);
    }

    @Override
    public T get() {
    // my javac generates useless new Object[0] if no args passed
        return apply(emptyObjectArray);
    }

    @Override
    public T apply(final Object[] arguments) {
        try {
            @SuppressWarnings("unchecked")
            final T value = (T) method.invoke(instance, arguments);
            return value;
        } catch ( final IllegalAccessException | InvocationTargetException ex ) {
            throw new RuntimeException(ex);
        }
    }

}