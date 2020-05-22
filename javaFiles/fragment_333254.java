static long process(int rows, int cols, int[] hor, int[] ver) {
    final long[][] a = new long[rows][cols];
    for (int i = 0; i < rows; i++) for (int j = 0; j < cols; j++) a[i][j] = 1;

    for (int h : hor) for (int j = 0; j < cols; j++) a[h - 1][j] = a[h][j] = a[h - 1][j] + a[h][j];
    for (int v : ver) for (int i = 0; i < rows; i++) a[i][v - 1] = a[i][v] = a[i][v - 1] + a[i][v];

    long max = 0;
    for (int i = 0; i < rows; i++) for (int j = 0; j < cols; j++) max = Math.max(max, a[i][j]);
    return max;
}