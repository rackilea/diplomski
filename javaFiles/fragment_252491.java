int[] arr = new int[] { 1, 2, 30, 4, 5, 30, 6 };

    int k = 30;
    int j = 0;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != k) {
            arr[j++] = arr[i];
        }
    }
    while (j < arr.length) {
        arr[j++] = 0;
    }