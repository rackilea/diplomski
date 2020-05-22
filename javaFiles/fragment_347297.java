public String toString()
{
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < getHeight(); i++)
    {
        for(int j = 0; j < getWidth(); j++)
        {
            builder.append(grid[i][j]);
        }
    }    
    return builder.toString();
}