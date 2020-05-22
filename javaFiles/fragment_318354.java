final class IntervalComparator<T extends Comparable<T>> implements
    Comparator<Interval<T>> {

    // Private constructor. Use the getInstance method instead.
    private IntervalComparator() {
    }

    private static IntervalComparator INSTANCE = new IntervalComparator();

    @SuppressWarnings("unchecked")
    public static <K extends Comparable<K>> IntervalComparator<K> getInstance() {
        return (IntervalComparator<K>)INSTANCE;
    }

    @Override
    public int compare(Interval<T> o1, Interval<T> o2) {
        // ... Comparison code goes here ...
    }
}