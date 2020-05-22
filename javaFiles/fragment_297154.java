public static<T> Consumer<Object> acceptType(Class<T> clazz, Consumer<? super T> cons) {
    return t -> {
        if (clazz.isInstance(t)) {
            cons.accept(clazz.cast(t));
        }
    };
}