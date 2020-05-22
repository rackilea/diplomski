@SafeVarargs
static <T> T findFirst(List<T> elements, Predicate<? super T>... filters) {
    return Arrays.stream(filters)
            .map(f -> elements.stream().filter(f).findFirst())
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst()
            .orElse(null);
}