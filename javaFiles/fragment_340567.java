int streamMethod(final String data, final IntPredicate predicate) {
    if (data.chars().anyMatch(predicate)) {
        doThrow();
    }
    return data.length();
}