public static int findLargestPos(int[] arr, int offset) {
    int n = arr.length;
    int mid = (int)Math.floor(arr.length / 2);

    if (arr.length <= 1) {
        return offset;
    }

    int[] arr2 = new int[mid];
    int[] arr3 = new int[arr.length - mid];

    System.arraycopy(arr, 0, arr2, 0, mid);
    System.arraycopy(arr, mid, arr3, 0, arr.length - mid);

    int index1 = findLargestPos(arr2, offset);
    int index2 = findLargestPos(arr3, offset + mid);

    if (arr[index1 - offset] > arr[index2 - offset]) {
        return index1;
    }

    return index2;
}