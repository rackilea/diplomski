// avoid this at all costs
int streamParallelMethod(final String data, IntPredicate predicate) {
    if (data.chars().parallel().anyMatch(predicate)) {
        doThrow();
    }
    return data.length();
}