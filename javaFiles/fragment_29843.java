public static int[] commonElements(int[] a, int[] b) {
    int count = 0;
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < b.length; j++) {
            if (a[i] == b[j]) {
                count++;
            }
        }
    }
    int[] array = new int[count];
    int p = 0;
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < b.length; j++) {
            if (a[i] == b[j]) {
                array[p] = a[i];
                p++;
            }
        }
    }
    return array;
}