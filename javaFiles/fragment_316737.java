private static Predicate<LocalDate> between(final LocalDate begin, final LocalDate end) {
    return new Predicate<LocalDate>() {
        @Override
        public boolean apply(LocalDate date) {
            return (date.compareTo(begin) >= 0 && date.compareTo(end) <= 0);
        }
    };
}