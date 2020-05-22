private static <K, V> Map<K, List<V>> groupByOrdered(List<V> list, Function<V, K> keyFunction) {
    return list.stream()
                .collect(Collectors.groupingBy(
                    keyFunction,
                    LinkedHashMap::new,
                    Collectors.toList()
                ));
}