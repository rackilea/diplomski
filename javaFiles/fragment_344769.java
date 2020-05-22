public static void fill(Integer[][] array, int column, int row, int height, int length) {
    if (row >= 0 && row < length && column >= 0 && column < height && array[column][row] == 1) {
        array[column][row] = counter;
        fill(array, column, row + 1, height, length);
        fill(array, column, row - 1, height, length);
        fill(array, column - 1, row, height, length);
        fill(array, column + 1, row, height, length);
    }
}