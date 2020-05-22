private static int consecutiveCompare(int[] array)
{
    int sum = 0;

    for (int i = 1; i < array.length; i++)
    {
        if (array[i] == array[i-1])
        {
            if (i == 1)
            {
                sum += array[i];
            }
            else if (array[i] != array[i-2])
            {
                sum += array[i];
            }
            sum += array[i];
        }
    }

    return sum;
}