public static String interleave(String string, int interval, String separator, boolean fromRight)
{
    char[] src = string.toCharArray();
    char[] sep = separator.toCharArray();
    int count = (src.length-1)/interval;
    char[] dst = new char[src.length + count * sep.length];
    int srcpos = 0, dstpos = 0;
    if (fromRight)
    {
        srcpos = dstpos = src.length - count * interval;
        if (srcpos > 0) System.arraycopy(src, 0, dst, 0, srcpos);
        if (count > 0)
        {
            System.arraycopy(sep, 0, dst, dstpos, sep.length);
            dstpos += sep.length;
            count--;
        }
    }
    for (int i = 0; i < count; i++)
    {
        System.arraycopy(src, srcpos, dst, dstpos, interval);
        srcpos += interval;
        dstpos += interval;
        System.arraycopy(sep, 0, dst, dstpos, sep.length);
        dstpos += sep.length;
    }
    if (dstpos < dst.length)
    {
        System.arraycopy(src, srcpos, dst, dstpos, dst.length - dstpos);
    }
    return String.valueOf(dst);
}