public static int findPivot(int[] a, int from, int to) {
    final int rangeLength = to - from + 1;
    if(rangeLength <= 7) {
        return a[(from + to)/2];
    } else if(rangeLength  <= 40) { // why test "a.length > 7" ?
        return computeMedian(a[from], a[(from + to)/2] , a[to]);
    } else {
        final int rangeLength_8 = (to - from) / 8;
        int x = computeMedian(a[from], a[from + rangeLength_8], a[from + 2 * rangeLength_8]);
        int y = computeMedian(a[from + 3 * rangeLength_8], a[from + 4 * rangeLength_8], a[from + 5 * rangeLength_8]);
        int z = computeMedian(a[from + 6 * rangeLength_8], a[from + 7 * rangeLength_8], a[to]);
        return computeMedian(x,y,z);
    }
}