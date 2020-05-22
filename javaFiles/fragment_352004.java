public boolean isFilledAt(int row, int col)  {
    if (row < 0 || row >= height || col < 0 || col >= width) {
        throw new FitItException("Out of Bounds!");
    }
    char[][] tempArray = new char[height][width];
    for (int i = 0; i < tempArray.length; i++) {
        for (int j = 0; j < tempArray[i].length; j++) {
            if (tempArray[row][col] == dc) {
                return true;
            }
        }
    }
    return false;
}