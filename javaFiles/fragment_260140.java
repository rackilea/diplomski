/*
 * The next two methods (which are package private and static) constitute
 * the entire API of this class.  Each of these methods obeys the contract
 * of the public method with the same signature in java.util.Arrays.
 */

static <T> void sort(T[] a, Comparator<? super T> c) {
    sort(a, 0, a.length, c);
}

static <T> void sort(T[] a, int lo, int hi, Comparator<? super T> c) {
    ...
}