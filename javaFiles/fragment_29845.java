static boolean binarySearch(double a) {
    double[] arr = {1, 2, 3, 4, 5, 6};
    Arrays.sort(arr);
    int first = 0;
    int last = arr.length - 1;

    while (first <= last) {
        int mid = first + (last - first) / 2;
        if (arr[mid] == a) {
            return true;
        } else if (arr[mid] < a) {
            first = mid + 1;
        } else /*if (arr[mid] > a)*/{
            last = mid - 1;
        }
    }
    return false;
}