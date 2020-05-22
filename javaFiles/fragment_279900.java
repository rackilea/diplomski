package gameOfLife;

public class LifeModel
{
private boolean[][] world;
private int numRows;
private int numCols;
private boolean[][] tempWorld;



public LifeModel(int rows, int cols)
{
    this.numRows=rows;
    this.numCols=cols;
    world = new boolean[rows][cols];
    initWorld();
}

private void initWorld()
{

    boolean done = false;

    while(!done)
    {
        int i = (int) (Math.random()*numRows);
        int j = (int) (Math.random()*numCols);
        if(j>0 && i>0 && i<numRows-1 && j<numCols-1)
        {
            /*
             world[i-1][j-1] = true;
             world[i-1][j] = true;
             world[i-1][j+1] = true;
             world[i][j+1] = true;
             world[i+1][j] = true;
             */
             world[i][j]=true;
             world[i+1][j]=true;
             world[i-1][j]=true;
             done = true;
        }
    }


}

public void nextGeneration()
{
    tempWorld = new boolean[numRows][numCols];

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

public void toggleCell(int r, int c)
{
    int count = numLivingNeighbors(r,c);
    if(!world[r][c] && count==3)
    {
        tempWorld[r][c] = true;
    }
    else if(world[r][c] && (count>=2 && count<=3))
    {
        tempWorld[r][c] = true;
    }
    else
    {
        tempWorld[r][c] = false;
    }
}

public int numLivingNeighbors(int r, int c)
{
    int count = 0;
    boolean newCells[][] = world;
    for(int i = -1; i<=1; i++)
    {
        for(int j = -1; j<=1; j++)
        {
            if(i!=0 || j!=0)
            {
                int row = r + i;
                int column = c + j;
                if(row>=0 && row < newCells.length && column>=0 && column<newCells[0].length && newCells[row][column])
                {
                    count++;
                }
            }
        }
    }
    return count;
}

public void userChange()
{

}

public boolean[][] getWorld()
{
    return world;
}


}