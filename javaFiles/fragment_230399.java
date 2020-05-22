public static int countNonleadingZeroBits(int i)
{
    int result = 0;
    while (i != 0)
    {
        if (i & 1 == 0)
        {
            result += 1;
        }
        i >>>= 1;
    } 
    return result;
}