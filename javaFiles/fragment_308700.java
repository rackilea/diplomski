for (int i = 0, n = size + size - 1; i < n; i++) {
    int j = min(i, size - 1);
    for (int col = i - j; col <= j; col++) {
        int row = i - col;

        /* case 1 */
        F(row, col);

        /* case 2 */
        F(size - row - 1, size - col - 1);
    }
}