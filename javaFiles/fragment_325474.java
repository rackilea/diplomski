public class GZIPUtils {

    public static ByteArrayOutputStream unGzipBytesOutputStream(byte[] bytes) throws IOException {
        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
        GZIPInputStream gzipInputStream = new GZIPInputStream(byteInputStream);

        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(gzipInputStream, byteOutputStream);

        return byteOutputStream;
}
}