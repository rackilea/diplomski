int[] arr = {1, 2, 3, 4};
    for (int i : arr) {
        System.out.println("i = " + i);
        arr[i] = 0;
        System.out.println("arr = " + Arrays.toString(arr));
    }

    for (int i : arr) {
        System.out.println(i);
    }