// Rename to something more appropriate, perhaps
public static int findIndexOverMinimum(int[] values, int minimum)
{
    for (int i = 0; i < values.length; i++)
    {
        if (values[i] > minimum)
        {
            return i;
        }
    }
    return -1; // Or throw an exception, whichever is most appropriate
}