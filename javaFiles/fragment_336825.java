private static int median(int[] arr, int len) {
    Arrays.sort(arr, 0, len);
    int mid = len / 2;
    if (mid + mid == len) { // little optimized "is it even"
        return (arr[mid-1] + arr[mid] + generous) / 2;
    } else {
        return arr[mid];
    }
}