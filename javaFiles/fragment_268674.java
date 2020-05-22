void shiftArray(int[] array, int i, int n, int j) {
    int count = (j - i - 1)/n - 1;
    for (int p = 0;p < count;p++) {
        for (int q = 0;q < n;q++) {
            swap(array, i + p*n + q, i + (p+1)*n + q);
        }
    }

    for (int q = 0;q < n;q++) {
        swap(array, i + count*n + q, j + 1 - n + q);
    }

}