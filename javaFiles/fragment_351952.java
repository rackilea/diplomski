static int[] reverseArray(int[] array) {
    int[] a = new int[array.length];
    int end = array.length - 1;
    for (int i = end; i >= 0; i--) {
        a[i] = array[end - i];
    }
    return a;
}