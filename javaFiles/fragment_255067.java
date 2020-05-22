public static <T, S extends Comparable<? super S>> Comparator<T> parseKeysAscending(
        List<Function<? super T, ? extends S>> keyExtractors) {

    if (keyExtractors.isEmpty()) {
        return (a, b) -> 0;
    } else {

        Function<? super T, ? extends S> firstSortKey = keyExtractors.get(0);
        List<Function<? super T, ? extends S>> restOfSortKeys = 
            keyExtractors.subList(1, keyExtractors.size());

        return Comparator.<T, S>comparing(firstSortKey)
            .thenComparing(parseKeysAscending(restOfSortKeys));
    }
}