class Parameter<T> {
    // ...
    private T value;
    private final Class<?> klass;

    public Parameter(T initialValue) throws IllegalArgumentException {
        if (!VALID_TYPES.contains(initialValue.getClass()))
            throw new IllegalArgumentException(...);
        value = initialValue;
        klass = initialValue.getClass();
    }

    @SuppressWarnings("unchecked")
    public void set(Object value) {
        if (value != null && value.getClass() != klass)
            throw new IllegalArgumentException(...);
        this.value = (T)value;
    }