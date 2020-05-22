public static int binarySearch(int[] a, int target) {
    return binarySearch(a, 0, a.length-1, target);
}

public static int binarySearch(int[] a, int start, int end, int target) {
    int middle = (start + end) / 2;
    if(end < start) {
        return -1;
    } 

    if(target==a[middle]) {
        return middle;
    } else if(target<a[middle]) {
        return binarySearch(a, start, middle - 1, target);
    } else {
        return binarySearch(a, middle + 1, end, target);
    }
}