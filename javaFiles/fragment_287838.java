static <T, K> Collection<T> uniqueBy(Function<T, K> groupBy, List<T>... lists) {
    Map<K, T> map = new LinkedHashMap<>();
    for (List<T> l : lists) {
        l.forEach(e -> map.merge(groupBy.apply(e), e, (o, n) -> o));
    }
    return map.values();
}