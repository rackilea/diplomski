static <T> void sort(T[] a, Comparator<? super T> c) {
    sort(a, 0, a.length, c);
}

static <T> void sort(T[] a, int lo, int hi, Comparator<? super T> c) {

    // ...

    // If array is small, do a "mini-TimSort" with no merges
    if (nRemaining < MIN_MERGE) {
        int initRunLen = countRunAndMakeAscending(a, lo, hi, c);
        binarySort(a, lo, hi, lo + initRunLen, c);
        return;
    }

    // ...