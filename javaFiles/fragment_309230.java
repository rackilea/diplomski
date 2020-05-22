public static long extractSub(final long l, final int nrBits, final int offset)
{
    final long rightShifted = l >>> offset;
    final long mask = (1L << nrBits) - 1L;
    return rightShifted & mask;
}