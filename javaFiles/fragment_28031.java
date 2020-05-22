public static <T, S> Observable<Map<T, S>> zipMaps(final Map<T, Observable<S>> tasks) {
    Objects.requireNonNull(tasks, "tasks is null");
    return Observable.combineLatest(
        tasks.entrySet()
            .stream()
            .map(entry -> Observable.combineLatest(
                Observable.just(entry.getKey()),
                entry.getValue(),
                Pair::with))
            .collect(ImmutableList.toImmutableList()),
        xs -> Arrays.stream(xs)
            .map(x -> (Pair<T, S>)x)
            .collect(ImmutableMap.toImmutableMap(Pair::getValue0, Pair::getValue1)));
}