public static <T> T coalesce(Supplier<T>... ts) {
    return asList(ts)
        .stream()
        .map(t -> t.get())
        .filter(t -> t != null)
        .findFirst()
        .orElse(null);
}