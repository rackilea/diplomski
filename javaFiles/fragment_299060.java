public static void replace (int[] arr) {
        int total = 0;
        int length = arr.length;
        for (int index = 0; index < length; index++)
            if (arr[index] != 0)
                arr[total++] = arr[index];
        Arrays.fill(arr, total, length, 0);
    }