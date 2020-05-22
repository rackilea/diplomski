public static class ValueWrapper<T> {
    public final T value;
    public final boolean isDefaultValue;

    public ValueWrapper(T value, boolean isDefaultValue) {
        this.value = value;
        this.isDefaultValue = isDefaultValue;
    }
}