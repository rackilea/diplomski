private long computeKey(Object o1, Object o2)
{
    int h1 = o1.hashCode();
    int h2 = o2.hashCode();

    if (h1 < h2)
    {
        int swap = h1;
        h1 = h2;
        h2 = swap;
    }

    return ((long)h1) << 32 | h2;
}