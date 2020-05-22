static void reverseArray(int[] arr, int start, int end) {
    if (start >= end)
        return;
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    reverseArray(arr, start + 1, end - 1);
}

public static void main(String[] args) {
    reverseArray(new int[]{1, 2, 3, 4, 5}, 0, 4);
}