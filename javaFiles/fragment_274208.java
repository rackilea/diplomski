private static <K,V,R> Map<K,R>
                       replaceAndSortValues(Map<K,V> m, Function<V,R> f, Comparator<R> c) {
    return m.entrySet().stream()
        .map(e -> Map.entry(e.getKey(), f.apply(e.getValue())))
        .sorted(Map.Entry.comparingByValue(c.reversed()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                  (a,b) -> { throw new AssertionError(); },
                                  LinkedHashMap::new));
}