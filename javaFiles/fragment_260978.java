Boolean SolveSudoku(int[][] grid)
{
    int row, col;

    if(!FindUnassignedLocation(grid, row, col))
        //all locations successfully assigned
        return true;

    for(int num = 1; num <= 9; num++)
    {
        //if number is allowed to be placed in the square
        if(NoConflicts(grid, row, col, num))
        {
            //place the number in the square
            grid[row][col] = num;

            //recur, if successful then stop
            if(SolveSudoku(grid))
                return true;

            //undo and try again
            grid[row][col] = UNASSIGNED;
        }
     }
     //this triggers backtracking from early decisions
     return false;
}