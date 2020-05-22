public static Iterable<LocalDate> datesBetween(final LocalDate start,
                                               final LocalDate end) {
    return new Iterable<LocalDate>() {
        @Override public Iterator<LocalDate> iterator() {
            return new Iterator<LocalDate>() {
                private LocalDate next = start;

                @Override
                public boolean hasNext() {
                    return !next.isAfter(end);
                }

                @Override
                public LocalDate next() {
                    if (next.isAfter(end)) {
                        throw NoSuchElementException();
                    }
                    LocalDate ret = next;
                    next = next.plusDays(1);
                    return ret;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    };
}