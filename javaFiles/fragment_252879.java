public class GunzipOutputStream
    extends OutputStream
{
    final private Thread _pump;

    // Streams
    final private PipedOutputStream _zipped;  // Compressed bytes are written here (by clients)
    final private PipedInputStream _pipe; // Compressed bytes are read (internally) here
    final private OutputStream _out; // Uncompressed data is written here (by the pump thread)

    // Internal state
    private IOException _e;

    public GunzipOutputStream(OutputStream out)
        throws IOException
    {
        _zipped = new PipedOutputStream();
        _pipe = new PipedInputStream(_zipped);
        _out = out;
        _pump = new Thread(new Runnable() {
            public void run() {
                InputStream in = null;
                try
                {
                    in = new GZIPInputStream(_pipe);

                    pump(in, _out);
                }
                catch (IOException e)
                {
                    _e = e;
                    System.err.println(e);
                    _e.printStackTrace();
                }
                finally
                {
                    try { in.close(); } catch (IOException ioe)
                    { ioe.printStackTrace(); }
                }
            }

            private void pump(InputStream in, OutputStream out)
                throws IOException
            {
                long count = 0;

                byte[] buf = new byte[4096];

                int read;
                while ((read = in.read(buf)) >= 0) {
                    System.err.println("===> Pumping " + read + " bytes");
                    out.write(buf, 0, read);
                    count += read;
                }
                out.flush();
                System.err.println("===> Pumped a total of " + count + " bytes");
            }
        }, "GunzipOutputStream stream pump " + GunzipOutputStream.this.hashCode());

        _pump.start();
    }

    public void close() throws IOException {
        throwIOException();
        _zipped.close();
        _pipe.close();
        _out.close();
    }

    public void flush() throws IOException {
        throwIOException();
        _zipped.flush();
    }

    public void write(int b) throws IOException {
        throwIOException();
        _zipped.write(b);
    }

    public void write(byte[] b) throws IOException {
        throwIOException();
        _zipped.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        throwIOException();
        _zipped.write(b, off, len);
    }

    public String toString() {
        return _zipped.toString();
    }

    protected void finish()
        throws IOException
    {
        try
        {
            _pump.join();
            _pipe.close();
            _zipped.close();
        }
        catch (InterruptedException ie)
        {
            // Ignore
        }
    }

    private void throwIOException()
        throws IOException
    {
        if(null != _e)
        {
            IOException e = _e;
            _e = null; // Clear the existing error
            throw e;
        }
    }
}