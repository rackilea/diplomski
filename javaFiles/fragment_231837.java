for (int i = left + 1; i <= right; i++) {
    if (a[i] < a[pivot]) {
        swap(i, cur, a);
        cur++;
    }
}