private static <T, K> Map<T, List<K>> invertedMapOfList(Map<K, List<T>> m) {
    return m.entrySet()
        .stream()
        .flatMap(e -> e.getValue()
            .stream()
            .map(v -> new AbstractMap.SimpleEntry<>(e.getKey(), v)))
        .collect(Collectors.groupingBy(Map.Entry::getValue,
            Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
}