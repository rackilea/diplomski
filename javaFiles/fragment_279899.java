public void nextGeneration()
{
    tempWorld = new boolean[numRows][numCols]; // Keep it the same size

    int rows = world.length;
    int columns = world[0].length;

    for(int i=0; i < rows; i++)
    {
        for(int j = 0; j < columns; j++)
        {
            toggleCell(i,j);
        }
    }
    world = tempWorld;
}