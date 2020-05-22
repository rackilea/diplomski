public final class LimitedOutputStream extends FilterOutputStream {
    private final long maxBytes;
    private long       bytesWritten;
    public LimitedOutputStream(OutputStream out, long maxBytes) {
        super(out);
        this.maxBytes = maxBytes;
    }
    @Override
    public void write(int b) throws IOException {
        ensureCapacity(1);
        super.write(b);
    }
    @Override
    public void write(byte[] b) throws IOException {
        ensureCapacity(b.length);
        super.write(b);
    }
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        ensureCapacity(len);
        super.write(b, off, len);
    }
    private void ensureCapacity(int len) throws IOException {
        long newBytesWritten = this.bytesWritten + len;
        if (newBytesWritten > this.maxBytes)
            throw new IOException("File size exceeded: " + newBytesWritten + " > " + this.maxBytes);
        this.bytesWritten = newBytesWritten;
    }
}