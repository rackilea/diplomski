int[][] reversed = new int[array.length][];
for (int i = 0; i < array.length; i++) {
    int[] row = array[array.length - i - 1];
    reversed[i] = new int[row.length];
    for (int j = 0; j < row.length; j++) {
        reversed[i][j] = row[row.length - j - 1];
    }
}