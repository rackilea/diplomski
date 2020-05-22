public static void dropChip(int selection, int count)
{   
    --selection;//make selection a human number
    for (int x = grid.length-1; x >= 0; --x)//set x to value of decremented r
    {
        if (grid[x][selection] == ' ')//while r(row) & selection is empty char
            {
                grid[x][selection] = userChip(count);//drop R or Y into grid  
                break; 
            }
            //else grid[x][selection] = userChip(count);//drop chip in next row of same column
    }

}