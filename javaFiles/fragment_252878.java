public class LimitedInputStream
    extends InputStream
{
    private long _limit;
    private long _read;
    private InputStream _in;

    public LimitedInputStream(InputStream in, long limit)
    {
        _limit= limit;
        _in = in;
        _read = 0;
    }
    @Override
    public int available()
        throws IOException
    {
        return _in.available(); // sure?
    }

    @Override
    public void close()
        throws IOException
    {
        _in.close();
    }

    @Override
    public boolean markSupported()
    {
        return false;
    }

    @Override
    public int read()
        throws IOException
    {
        int read = _in.read();

        if(-1 == read)
            return -1;

        ++_read;

        if(_read > _limit)
            return -1;
            // throw new IOException("Read limit reached: " + _limit);

        return read;
    }

    @Override
    public int read(byte[] b)
        throws IOException
    {
        return read(b, 0, b.length);
    }

    @Override
    public int read(byte[] b, int off, int len)
        throws IOException
    {
        // 'len' is an int, so 'max' is an int; narrowing cast is safe
        int max = (int)Math.min((long)(_limit - _read), (long)len);

        if(0 == max && len > 0)
            return -1;
            //throw new IOException("Read limit reached: " + _limit);

        int read = _in.read(b, off, max);

        _read += read;

        // This should never happen
        if(_read > _limit)
            return -1;
            //throw new IOException("Read limit reached: " + _limit);

        return read;
    }

    @Override
    public long skip(long n)
        throws IOException
    {
        long max = Math.min((long)(_limit - _read), n);

        if(0 == max)
            return 0;

        long read = _in.skip(max);

        _read += read;

        return read;
    }
}