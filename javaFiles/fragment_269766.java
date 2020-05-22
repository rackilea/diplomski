public static <T,V> Function<V,T> create(
    Supplier<? extends T> constructor, BiConsumer<? super T, ? super V> setter) {
    return v -> {
        T t=constructor.get();
        setter.accept(t, v);
        return t;
    };
}