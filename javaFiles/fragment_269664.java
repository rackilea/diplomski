private static <T, TT extends T> T mode0(Collection<TT> collection,
                                         Comparator<? super T> comparator) {
    return collection.stream()
                     .collect(Collectors.groupingBy(t -> t, 
                                  () -> new TreeMap<>(comparator), 
                                  Collectors.counting()))
                     .entrySet()
                     .stream()
                     .max(Map.Entry.comparingByValue())
                     .map(Map.Entry::getKey)
                     .orElseThrow(IllegalArgumentException::new);
}