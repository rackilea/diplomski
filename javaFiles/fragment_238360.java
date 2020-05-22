class LimitedFilter<T> implements Predicate<T> {
    int matches = 0;
    final int limit;
    private Predicate<T> delegate;
    public LimitedFilter<T>(Predicate<T> p, int limit) { 
        delegate = p; this.limit = limit;
    }
    public boolean test(T toTest) {
        if (matches > limit) return true;
        boolean result = delegate.test(toTest);
        if (result) matches++;
        return result;
    }
}