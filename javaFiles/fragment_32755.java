static void swap(int[] A, int a, int b) {
    if (a != b) {
        int t = A[a];
        A[a] = A[b];
        A[b] = t;
    }
}