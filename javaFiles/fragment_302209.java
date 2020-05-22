public boolean isFilledAt(int row, int col) {
    if(row < 0 || row >= height || col < 0 || col >= width)
        throw new FitItException("Oops! Out of bounds!");
    else 
        return (shape[row][col] == dc);
}