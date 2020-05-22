public static int[] mergeSort(int[] list1, int[] list2) {
    int[] list3 = new int[list1.length + list2.length];
    int num = 0;
    int num2 = 0;
    int j = 0;
    while (num != list1.length && num2 != list2.length) {
        int x = list1[num];
        int y = list2[num2];
        if (x < y) {
            list3[j] = x;
            j += 1;
            num += 1;
        } else {
            list3[j] = y;
            num2 += 1;
            j += 1;
        }
    }

    if (num == list1.length) {
        for (int i = num2; i < list2.length; i++, j++) {
            list3[j] = list2[i];
        }
    } else {
        for (int i = num; i < list1.length; i++, j++) {
            list3[j] = list1[i];
        }
    }
    return list3;
}