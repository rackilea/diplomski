char array[][] = new char[10][10];    

class Tuple //helper class
{
    public int i,  j;
    Tuple(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
}
public Tuple matches(char c) //return indices (Tuple-instance) or null if not found
{

    for(int i = 0; i < array.length; i++)
    {
        for(int j = 0; j < array[0].length; j++)
        {
            if(array[i][j] == c)
            {
                return new Tuple(i, j);
            }

        }
    }
    return null;
}