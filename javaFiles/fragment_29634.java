public static void fillWithFalse(boolean[][] array, int row, int col) {
    if (row < array.length) {
        if (col < array[row].length) {
            array[row][col] = false;
            fillWithFalse(array, row, col + 1);
        } else {
            fillWithFalse(array, row + 1, 0);
        }
    }
}