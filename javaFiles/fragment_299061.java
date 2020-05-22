double[] arr = {0.0, 4.8, 5.1, 0.0, 9.8};
    int current = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) {
            arr[current++] = arr[i];
        }
    }
    arr = Arrays.copyOf(arr, current);