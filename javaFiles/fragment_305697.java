public static void move(String array[][], int steps, int row, int col) {
    if (steps < 0 || row < 0 || row >= 8 || col < 0 || col >= 8)
        return;
    array[row][col] = "X";
    move(array, steps - 1, row - 2, col - 1);
    move(array, steps - 1, row - 2, col + 1);
    move(array, steps - 1, row + 2, col - 1);
    move(array, steps - 1, row + 2, col + 1);
    move(array, steps - 1, row - 1, col - 2);
    move(array, steps - 1, row - 1, col + 2);
    move(array, steps - 1, row + 1, col - 2);
    move(array, steps - 1, row + 1, col + 2);
}