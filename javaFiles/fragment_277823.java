public static int linear(int arr[], int a) {
    for (int pos = 0; pos < arr.length; pos++) {
        if (arr[pos] == a) {
            return pos;
        }
    }
    return -1;
}