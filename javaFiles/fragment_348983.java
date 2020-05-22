public class ClosingInputStream extends InputStream {

    private InputStream stream;
    private Closeable closer;

    public ClosingInputStream(InputStream stream, Closeable closer) {
        this.stream = stream;
        this.closer = closer;
    }

    // The other InputStream methods...

    @Override
    public void close() throws IOException {
        closer.close();
    }

}