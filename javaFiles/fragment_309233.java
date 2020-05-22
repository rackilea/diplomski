public boolean moveOn(int row, int column) {
    //if the previous location was not the last in the row move to ne next cell in said row.
    //if it was the last location in the row, move to the first column of the next row
    if (column + 1 != L) {return solve(row, column + 1);}
    else if (row + 1 != L) {return solve(row + 1, 0);}
    else {show(); return true;}  // reached end of grid, solved
}