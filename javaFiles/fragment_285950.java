public static <T> void sort(T[] a, Comparator<? super T> c) {
    if (c == null)
        c = NaturalOrder.INSTANCE;
    if (LegacyMergeSort.userRequested)
        legacyMergeSort(a, c);
    else
        TimSort.sort(a, 0, a.length, c, null, 0, 0);
}