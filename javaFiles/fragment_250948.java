public static <T> void forEach(@NonNull Iterable<T> iterable, @NonNull ObjIntConsumer<T> consumer) {
    int i = 0;
    for (T t : iterable) {
        consumer.accept(t, i++);
    }
}