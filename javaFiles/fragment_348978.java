public class BinaryCloseable implements Closeable {

    private Closeable first;
    private Closeable last;

    public BinaryCloseable(Closeable first, Closeable last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public void close() throws IOException {
        try {
            first.close();
        } finally {
            last.close();
        }
    }

}