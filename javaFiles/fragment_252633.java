if (a[j] < 0) {
    if (a[j] < a[j+1]) {
        int swap = a[j];
        a[j] = a[j+1];
        a[j+1] = swap;
    }
} else {
    if (a[j] > a[j+1] && a[j+1] > 0) {
        int swap = a[j];
        a[j] = a[j+1];
        a[j+1] = swap;
    }
}