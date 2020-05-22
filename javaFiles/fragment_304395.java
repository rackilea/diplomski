private void applyManyFilters(long[] initialData, LongPredicate... filters) {
    long[] dataToUse = Arrays.stream(initialData)
                             .filter(v -> Arrays.stream(filters)
                                                .allMatch(f -> f.test(v)))
                             .toArray();
    // Use filtered data
}