public static void run_test(int x, int y, int a[][], int v, int size, boolean first) {
    if ((x < 0) || (x >= size))
        return;
    if ((y < 0) || (y >= size))
        return;
    if (a[x][y] != 2 && (first || a[x][y] != v)) {
        a[x][y] = v;
        if (x + 1 < size) {
            run_test(x + 1, y, a, v, size, false);
        }
        if (x > 0) {
            run_test(x - 1, y, a, v, size, false);
        }
        if (y + 1 < size) {
            run_test(x, y + 1, a, v, size, false);
        }
        if (y > 0) {
            run_test(x, y - 1, a, v, size, false);
        }
    }
}