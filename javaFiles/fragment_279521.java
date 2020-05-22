private static void fill(int[] arr, int N, int index) {
    if (arr == null) {
        return;
    }
    if (N == 0) {
        for (; index < arr.length; index++) {
            arr[index] = 0;
        }
    } else if (index == arr.length - 1) {
        arr[index] = N;
    } else {
        for (int j = N; j >= 0; j--) {
            arr[index] = j;
            fill(arr, N - j, index + 1);
        }
    }

    if (index >= arr.length - 1) {
        // use your array
        System.out.println(Arrays.toString(arr));
    }
}