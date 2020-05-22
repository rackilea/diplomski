public static void fillWithFalse(boolean[][] array, int row) {
    if (row < array.length) {
        fillWithFalse(array[row], 0);
        fillWithFalse(array, row + 1);
    }
}

public static void fillWithFalse(boolean[] array, int col) {
    if (col < array.length) {
        array[col] = false;
        fillWithFalse(array, col + 1);
    }
}