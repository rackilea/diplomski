void sink(int [] A, int i, int n) {
    int highest = 2*i+1;
    if (2*i+1 >= n)
        return;
    if (2*i+2 < n && A[2*i+2] > A[highest])
        ++highest;
    if (A[i] < A[highest]) {
        swap(A, i, highest);
        sink(A, highest, n);
    }
}

void heapify(int [] A, int n) {
    for (int i = n/2; i >= 0; --i) {
        sink(A, i, n);
    }
}