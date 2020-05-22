int counter = 0;
for (int row  = 0; row < grid.getNumRows(); row++) {
    for (int col = 0; col < grid.getNumCols(); col++) {
        if (isFlowerAt(grid, row, col)){
            counter++;
        }
    }
}
return counter;

private boolean isFlowerAt(Grid grid, int row, int col) {
    //Return true if a flower is located at (row, col)
}