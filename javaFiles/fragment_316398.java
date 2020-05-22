public static int biggest(int[][] grid, int big)
{
int total=0;
    for (int r = 0; r < grid.length; r++) {
        for (int c = 0; c < grid[r].length; c++) {

            if (r==c) {
               total+=grid[r][c];
            }
        }
    }


return total;
}