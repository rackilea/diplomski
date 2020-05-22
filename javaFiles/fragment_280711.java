public int getCheckersBlue()
{
    int counter = 0;
    for(int x = 0; x < 8; x++)
    {
        for(int y = 0; y < 8; y++)
        {
            if(Color.BLUE.equals(c[x][y]))
            {
                counter++;
            }
        }
    }
    return counter;
}