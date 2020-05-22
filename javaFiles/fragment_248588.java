public static <T extends Comparable<T>> int findMinIndex(final List<T> xs) {
    int minIndex;
    if (xs.isEmpty()) {
        minIndex = -1;
    } else {
        final ListIterator<T> itr = xs.listIterator();
        T min = itr.next(); // first element as the current minimum
        minIndex = itr.previousIndex();
        while (itr.hasNext()) {
            final T curr = itr.next();
            if (curr.compareTo(min) < 0) {
                min = curr;
                minIndex = itr.previousIndex();
            }
        }
    }
    return minIndex;
}