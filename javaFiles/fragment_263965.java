public static int max(int[] array)
{
    int highest = array[0];
    for (int i = 1; i < array.length; i++)
    {
        if (array[i] > highest)
        {
            highest = array[i];
        }
    }
    return highest;
}