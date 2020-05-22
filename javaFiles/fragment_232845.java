public static <T> List<T> execute(
        final List<T> list,
        final Predicate<? super T> filter,
        final Comparator<? super T> sort,
        final Integer limit) {
    final FluentIterable<T> filtered = FluentIterable.from(list).filter(filter);
    return Ordering.from(sort).leastOf(filtered, limit);
}