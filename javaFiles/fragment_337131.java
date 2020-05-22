public interface InputStreamListener {
    void onBytesRead(long totalBytes);
}

public class PublishingInputStream extends FilterInputStream {
    private final InputStreamListener;
    private long totalBytes = 0;

    public PublishingInputStream(InputStream in, InputStreamListener listener) {
       super(in);
       this.listener = listener;
    }

    @Override
    public int read(byte[] b) {
       int count = super.read(b);
       this.totalBytes += count;
       this.listener.onBytesRead(totalBytes);
    }

    // TODO: override the other read() methods
}