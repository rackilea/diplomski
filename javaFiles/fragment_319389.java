public static <T, R> List<R> multipleMapping(
    Collection<T> collection, Function<T, R> function) {

    return collection.stream()
            .map(function)
            .collect(Collectors.toList());
}