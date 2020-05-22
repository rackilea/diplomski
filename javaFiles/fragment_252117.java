public boolean columnsIdentical(int[][] array, int colIndex1, int colIndex2) {
    for (int row = 0; row < array.length; row++ ) {
        if (array[row][colIndex1] != array[row][colIndex2]) {
            return false;
        }
    }
    return true;
}