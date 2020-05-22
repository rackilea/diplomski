static int[] ArrayCopy(int[] t)
{
    int numPositives = 0;
    for(int i = 0 ; i < t.length ; i++)
    {
        if(t[i] > 0)numPositives++;
    }

    int[] newArray = new int[numPositives];
    int curPositive = 0;

    for(int i = 0 ; i < t.length ; i++)
    {
        if(t[i] > 0)
        {
             newArray[curPositive] = t[i];
             curPositive++;
        }
    }

    return newArray
}