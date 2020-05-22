class ValueContainer<T> {

    private final T value;
    private final Boolean terminated;

    private ValueContainer(final T value, final Boolean terminated) {
        this.value = value;
        this.terminated = terminated;
    }

    public static <T> ValueContainer<T> of(final T value) {
        return new ValueContainer<>(value, false);
    }

    public static <T> ValueContainer<T> terminated() {
        return new ValueContainer<>((T) null, true);
    }

    //...getters
}