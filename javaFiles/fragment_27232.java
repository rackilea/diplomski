static int[] mergeArray(int[] arr1, int[] arr2) {
    int[] arr3 = new int[arr1.length * 2];
    int count = 0;
    for (int i = 0; i < arr1.length; i++) {
        arr3[count++] = arr1[i];
        arr3[count++] = arr2[i];
    }
    return arr3;
}