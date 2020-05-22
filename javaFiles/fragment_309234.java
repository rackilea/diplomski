public boolean solve(int row, int column) {
    //pass over any numbers that are not empty
    if (getSquare(row, column) != 0) {return moveOn(row, column);}
    else {
        //attempt to find a valid number for the location
        for (int n = 1; n <= L; n++) {
            if (checkRow(row, n) && checkCol(column, n) && checkSquare(row, column, n)) {
                // If a number is allowed at a specific location set that location to the number
                setSquare(row, column, n);
                //Begin checking for a solution based on previous numbers changed           
                if (moveOn(row, column)) {
                    return true;       // solved, yay!
                }
            }               
        }
        //If no number is allowed in this space backtrack to the last successful number 
        //changed and reset all locations that have been changed recursively
        setSquare(row, column, 0);          
    }
    //If the puzzle is unsolveable
    return false;
}