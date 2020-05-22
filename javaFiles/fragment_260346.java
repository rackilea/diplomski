public static int[] mergeArray(int[] a, int[] b) {
    int length = (a.length + b.length);
    int result[] = new int[length];

    for (int i = 0, e = 0; i <= a.length - 1; i++, e += 2) {
        result[e] = a[i];
        result[e + 1] = b[i];
    }

    return result;
}