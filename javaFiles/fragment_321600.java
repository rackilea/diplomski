public class ZipGuard extends java.io.FilterInputStream {
    public ZipGuard(ZipInputStream is) {
        super(is);
    }

    @Override
    public void close() throws IOException {
        ((ZipInputStream) in).closeEntry();
    }
}