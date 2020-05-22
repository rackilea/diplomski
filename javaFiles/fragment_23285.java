public static <T extends Object> Observable<List<T>> bufferUntil(
        Observable<T> source,
        final Func1<T, Boolean> bufferClosingCriteria) {

    return source.publish(o -> o.buffer(() -> o.filter(bufferClosingCriteria)));
}