public static void quickSort(int[] arr, int start, int end) {
    int p1 = partition(arr, start, end);
    int p2 = p1;

    /* skip elements identical to the pivot */
    while (++p2 <= end && arr[p2] == arr[p1])
        continue;

    if (p1 - 1 > start) {
        quickSort(arr, start, p1 - 1);
    }
    if (p2 < end) {
        quickSort(arr, p2, end);
    }
}

public static int partition(int[] arr, int start, int end) {
    /* choose pivot at 3/4 or the array */
    int i = end - ((end - start + 1) >> 2);
    int pivot = arr[i];
    arr[i] = arr[end];
    arr[end] = pivot;

    for (i = start; i < end; i++) {
        if (arr[i] < pivot) {
            int temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
        }
    }

    int temp = arr[start];
    arr[start] = pivot;
    arr[end] = temp;

    return start;
}