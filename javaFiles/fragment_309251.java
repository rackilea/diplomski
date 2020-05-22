int[] arr = {1, 2, 3, 4};
    for (int i = 0; i < arr.length; i++) {
        arr[i] = 0;
    }

    for (int i : arr) {
        System.out.println(i);
    }