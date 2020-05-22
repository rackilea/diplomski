private static class ByteCache 
{
    private ByteCache(){}

    static final Byte cache[] = new Byte[-(-128) + 127 + 1];

    static 
    {
        for(int i = 0; i < cache.length; i++)
            cache[i] = new Byte((byte)(i - 128));
    }
}