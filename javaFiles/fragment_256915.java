private static final Comparator<? extends Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
    @Override
    public int compare(final Comparable o1, final Comparable o2) {
        return o1.compareTo(o2);
    }
};

private static <T> Comparator<T> naturalOrder() {
    return (Comparator<T>) NATURAL_ORDER;
}

public static <T> void sort(final T[] array) {
    if (!Comparable.class.isAssignableFrom(array.getClass().getComponentType())) {
        throw new IllegalArgumentException(
              "Array Component Type must implement Comparable");
    }

    sort(array, naturalOrder());
}

public static <T> void sort(final T[] array, final Comparator<? super T> comparator) {
    // implement sort here
}