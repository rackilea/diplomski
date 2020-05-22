private static <T, U extends Collection<?>> Stream<T> getStreamOfMappingToN(Map<T, U> map) {
    return map.entrySet().stream().map(q -> q.getKey());
}

private static <T, U extends Collection<?>> Stream<T> getStreamOfMergedDistinctMappingToN(Map<String, Map<T, U>> map) {
    return map.entrySet().stream()
            .flatMap(p -> getStreamOfMappingToN(p.getValue())).distinct();
}