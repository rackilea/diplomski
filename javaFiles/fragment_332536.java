public static int getElement(int[][] spot, int row, int col) {
    if (row < spot.length && spot.length > 0 && row >= 0 && col < spot[row].length && spot[row].length > 0 && col >= 0) {
        return spot[row][col];
    } else {
        return -1;
    }
}