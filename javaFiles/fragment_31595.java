public static void quickSort(final int size) {
    int l = 0;
    int r = size - 1;
    int q, i = 0;
    int tmpr = r;
    while (true) {
        i--;
        while (l < tmpr) {
            q = partition(l, tmpr);
            arr[tmpr] = -arr[tmpr];
            tmpr = q - 1;
            ++i;
        }
        if (i < 0)
            break;
        l++;
        tmpr = findNextR(l, size);
        arr[tmpr] = -arr[tmpr];
    }
}

private static int findNextR(final int l, final int size) {
    for (int i = l; i < size; ++i) {
        if (arr[i] < 0)
            return i;
    }
    return size - 1;
}

private static int partition(int l, int r) {
    long pivot = arr[(l + r) / 2];
    while (l <= r) {
        while (arr[r] > pivot)
            r--;
        while (arr[l] < pivot)
            l++;
        if (l <= r) {
            long tmp = arr[r];
            arr[r] = arr[l];
            arr[l] = tmp;
            l++;
            r--;
        }
    }
    return l;
}