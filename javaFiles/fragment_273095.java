public static <T> List<T> find(List<T> list, String query, Function<T, String> keyExtractor) {
    return list
        .stream()
        .filter(s -> keyExtractor.apply(s).contains(query))
        .collect(Collectors.toList());
}