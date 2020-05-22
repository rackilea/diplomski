private static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
}

public static void main(String[] args) {
    // Generate a sample
//      ArrayList<Integer> list = new ArrayList<>(64);
//      for (int i = 0; i < 64; i++) list.add(i);
//      Collections.shuffle(list);
//      System.out.println(list);
    int[] arr = {40, 9, 2, 62, 8, 42, 46, 23, 61, 45, 63, 48, 43, 36, 33, 32, 1, 55, 7, 17, 16, 25, 5, 26, 22, 11, 56, 38, 60, 31, 58, 29, 51, 34, 24, 54, 4, 3, 30, 20, 57, 18, 50, 44, 41, 12, 59, 6, 53, 39, 37, 35, 28, 13, 14, 15, 0, 19, 49, 52, 21, 27, 47, 10};

    modSort(arr, 0, arr.length-1);

    System.out.println(Arrays.toString(arr));
}