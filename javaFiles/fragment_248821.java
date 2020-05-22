private static final int[] logTable = new int[256];

static
{
    logTable[0] = logTable[1] = 0;
    for (int i=2; i<256; i++) logTable[i] = 1 + logTable[i/2];
    logTable[0] = -1;
}

public static final int log2(float f)
{
    int x = Float.floatToIntBits(f);
    int c = x >> 23;

    if (c != 0) return c - 127; //Compute directly from exponent.
    else //Subnormal, must compute from mantissa.
    {
        int t = x >> 16;
        if (t != 0) return logTable[t] - 133;
        else return (x >> 8 != 0) ? logTable[t] - 141 : logTable[x] - 149;
    }
}