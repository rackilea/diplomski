public class SkipInputStream extends FilterInputStream
{
    private static final int MAX_SKIP_BUFFER_SIZE = 2048;

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected SkipInputStream (InputStream in)
    {
        super(in);
    }

    /**
     * Same implementation as InputStream#skip
     *
     * @param n
     * @return
     * @throws IOException
     */
    public long skip(long n)
        throws IOException
    {
        long remaining = n;
        int nr;

        if (n <= 0) {
            return 0;
        }

        int size = (int)Math.min(MAX_SKIP_BUFFER_SIZE, remaining);
        byte[] skipBuffer = new byte[size];
        while (remaining > 0) {
            nr = in.read(skipBuffer, 0, (int)Math.min(size, remaining));
            if (nr < 0) {
                break;
            }
            remaining -= nr;
        }

        return n - remaining;
    }

}