final class FieldSpy<T>
        implements Supplier<T>, Consumer<T> {

    private final Object instance;
    private final Field field;

    private FieldSpy(final Object instance, final Field field) {
        this.instance = instance;
        this.field = field;
    }

    static <T> FieldSpy<T> spyField(final Class<?> declaringClass, final Object instance, final String fieldName)
            throws NoSuchFieldException {
        final Field field = declaringClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        return new FieldSpy<>(instance, field);
    }

    @Override
    public T get() {
        try {
            @SuppressWarnings("unchecked")
            final T value = (T) field.get(instance);
            return value;
        } catch ( final IllegalAccessException ex ) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void accept(final T value) {
        try {
            field.set(instance, value);
        } catch ( final IllegalAccessException ex ) {
            throw new RuntimeException(ex);
        }
    }

}