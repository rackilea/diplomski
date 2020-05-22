public static int binarySearch(int key, int[] array) {
    int left = 0;
    int mid;
    int right = array.length - 1;
    int i = 0;
    while (left <= right) {
        mid = (left + right)/2;
        int comp = Integer.compare(key, array[mid]);
        i++;
        if (comp < 0) {
            right = mid - 1;
        }
        else if (comp > 0) {
            left = mid + 1;
        }
        else {
            break; // success
        }
    }
    return i;
}