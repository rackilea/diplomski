public class BufferedBZIP2FilterFactory {
    public InputStream makeFilter(InputStream in) {
        BufferedInputStream buffer = new BufferedInputStream(in);
        return new CBZip2InputStream(buffer);
    }
}