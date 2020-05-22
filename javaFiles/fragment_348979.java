public class CompositeCloseable implements Closeable {

    private Closeable target;

    public CompositeCloseable(Closeable... closeables) {
        target = new Closeable() { public void close(){} };
        for (Closeable closeable : closeables) {
            target = new BinaryCloseable(target, closeable);
        }
    }

    @Override
    public void close() throws IOException {
        target.close();
    }

}