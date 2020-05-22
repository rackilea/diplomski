public class ListenableInputStream extends InputStream {

    private final InputStream wraped;
    private final ReadListener listener;
    private final long minimumBytesPerCall;
    private long bytesRead;

    public ListenableInputStream(InputStream wraped, ReadListener listener, int minimumBytesPerCall) {
        this.wraped = wraped;
        this.listener = listener;
        this.minimumBytesPerCall = minimumBytesPerCall;
    }


    @Override
    public int read() throws IOException {
        int read = wraped.read();
        if (read >= 0) {
            bytesRead++;
        }
        if (bytesRead > minimumBytesPerCall || read == -1) {
            listener.onRead(bytesRead);
            bytesRead = 0;
        }
        return read;
    }

    @Override
    public int available() throws IOException {
        return wraped.available();
    }

    @Override
    public void close() throws IOException {
        wraped.close();
    }

    @Override
    public synchronized void mark(int readlimit) {
        wraped.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        wraped.reset();
    }

    @Override
    public boolean markSupported() {
        return wraped.markSupported();
    }

    interface ReadListener {
        void onRead(long bytes);
    }
}