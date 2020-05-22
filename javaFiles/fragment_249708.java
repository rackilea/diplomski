for (int i = 0; i < arr.length - 1; i++) {
    int maxIndex = i;
    for (int k = i + 1; k < arr.length; k++) {
        if (arr[k] > arr[maxIndex]) {
            maxIndex = k;
        }
    }
    int temp = arr[i];
    arr[i] = arr[maxIndex];
    arr[maxIndex] = temp;
}