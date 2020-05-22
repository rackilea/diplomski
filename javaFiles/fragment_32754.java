static int findMIN(int[] A, int c) {
    int x = c;
    for (; c < A.length; c++) {
        if (A[c] < A[x]) {
            x = c;
        }
    }
    return x;
}