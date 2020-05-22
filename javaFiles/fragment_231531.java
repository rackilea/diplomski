public static <T> SortedSet<T> topValues(final int n, final Comparator<T> comparator) {
    return new TreeSet<T>(comparator) {
        @Override
        public boolean add(T t) {
            // if less than N in size, just try to add it.
            if (super.size() < n)
                return super.add(t);

            T first = super.first();
            // if smaller than the first, discard it.
            if (comparator.compare(t, first) <= 0)
                return false;
            // otherwise try to add it.
            super.remove(first);
            super.add(t);
            return true;
        }
    };
}