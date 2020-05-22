public static int[][] makeSquareMultiplicationTable(int sideLength) {
    int[][] table = new int[sideLength][sideLength];
    for (int row = 1; row <= sideLength; row++) {
        for (int col = 1; col <= sideLength; col++) {
            table[row-1][col-1] = row * col;
        }
    }
    return table;
}