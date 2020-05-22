public static int MaxProduct(int... a) {  // the max possible product from an array
    int i = 0;
    int j = 0;
    int m = 0;
    int n = a.length;
    while (i < n) {
        j = i + 1;  // TODO: 1
        while (j < n) {
            if (a[i] * a[j] > m) {
                m = a[i] * a[j];
            }
            j++; // TODO:2
        }
        i++;
    }
    return m;
}