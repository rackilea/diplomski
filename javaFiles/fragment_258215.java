int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    int[] array2 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    int a1 = array1.length;
    int a2 = array2.length - 1;
    int j = 0;

    while (a1 > 1) {
        a1 = a1 / 2;
        int l = j;
        for (int i = j; i <= l + a1;) {
            array2[a2 - i] = array1[2*l + a1 - i];
            j = ++i;
        }
    }
    System.out.println(Arrays.toString(array2));