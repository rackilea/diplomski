public int count(int[] values, int value)
{
    int count = 0;
    for (int current : values)
    {
        if (current == value)
            count++;
    }
    return count;
}