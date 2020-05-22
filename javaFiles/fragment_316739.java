private static <T extends Comparable<? super T>> Predicate<T> between(final T begin, final T end) {
    return new Predicate<T>() {
        @Override
        public boolean apply(T value) {
            return (value.compareTo(begin) >= 0 && value.compareTo(end) <= 0);
        }
    };
}