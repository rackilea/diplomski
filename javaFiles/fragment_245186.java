public void populateGrid()
{
    for(int x =0; x<gridCells[x].length-1; x++) // -1 to avoid outofboundsexception error 
    {
        for(int y =0; y<gridCells[y].length-1; y++)
        {
            gridCells[x][y] = (char)(r.nextInt(numberOfRegions) + 'a'); 
        }
    }
}