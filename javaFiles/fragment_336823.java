/** Generous or not: one to round up, zero to round down. */
private static final int generous = 1;

private static int median(int[] arr) {
    Arrays.sort(arr);
    int mid = arr.length / 2;
    if (mid + mid == arr.length) { // little optimized "is it even"
        return (arr[mid-1] + arr[mid] + generous) / 2;
    } else {
        return arr[mid];
    }
}