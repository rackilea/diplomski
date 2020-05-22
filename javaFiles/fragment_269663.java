static <T> T mode(Collection<? extends T> collection, Comparator<? super T> comparator) {
    return mode0(collection, comparator);
}

private static <T, TT extends T> T mode0(Collection<TT> collection,
                                         Comparator<? super T> comparator) {
    return collection.stream()
                     .collect(Collectors.groupingBy(t -> t, 
                                  () -> new TreeMap<>(comparator), 
                                  Collectors.counting()))
                     .entrySet()
                     .stream()
                     .reduce(BinaryOperator.maxBy(
                                  Comparator.comparingLong(Map.Entry::getValue)))
                     .map(Map.Entry::getKey)
                     .orElseThrow(IllegalArgumentException::new);
}