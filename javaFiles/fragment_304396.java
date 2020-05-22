private void applyManyFilters(long[] initialData, LongPredicate... filters) {
    long[] dataToUse = Arrays.stream(initialData)
                             .filter(combine(filters))
                             .toArray();
    // Use filtered data
}
public static LongPredicate combine(LongPredicate... filters) {
    return Arrays.stream(filters)
                 .reduce(LongPredicate::and)
                 .orElse(x -> true);
}