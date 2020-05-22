int[] arr = {1, 2, 3, 4};
    for (int index = 0; index < arr.length; index++) {
        int i = arr[index];
        arr[i] = 0;
    }

    for (int i : arr) {
        System.out.println(i);
    }