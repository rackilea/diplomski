public static void insertionSort(int a[], int left, int right) {
    int j;
    for (int p = left; p < right; p++) {
        int tmp = a[p];
        for(j = p; j > 0 && tmp < a[j - 1]; j--) {
            a[j] = a[j-1];
        }
        a[j] = tmp;
    }
}