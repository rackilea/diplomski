public class ConcatInputStream extends InputStream {
    private final InputStream[] is;
    private int last = 0;

    ConcatInputStream(InputStream[] is) {
        this.is = is;
    }

    public static InputStream of(InputStream... is) {
        return new ConcatInputStream(is);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        for (; last < is.length; last++) {
            int read = is[last].read(b, off, len);
            if (read >= 0)
                return read;
        }
        throw new EOFException();
    }

    @Override
    public int read() throws IOException {
        for (; last < is.length; last++) {
            int read = is[last].read();
            if (read >= 0)
                return read;
        }
        throw new EOFException();
    }

    @Override
    public int available() throws IOException {
        long available = 0;
        for(int i = last; i < is.length; i++)
            available += is[i].available();
        return (int) Math.min(Integer.MAX_VALUE, available);
   }
}