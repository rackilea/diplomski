public static boolean checkReversed(int[] x, int[] y)
{
    // For production code, possibly add nullity checks here (see comments)
    if (x.length != y.length)
    {
        return false;
    }
    // Loop through x forwards and y backwards
    for (int i = 0; i < x.length; i++)
    {
        if (x[i] != y[y.length - 1 - i])
        {
            // As soon as we've found a "mistake" we can exit:
            // This is simpler (IMO) than keeping a "check" variable
            return false;
        }
    }
    return true;
}