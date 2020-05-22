public static String readString(InputStream inputStream) throws IOException {

    ByteArrayOutputStream into = new ByteArrayOutputStream();
    byte[] buf = new byte[4096];
    for (int n; 0 < (n = inputStream.read(buf));) {
        into.write(buf, 0, n);
    }
    into.close();
    return new String(into.toByteArray(), "UTF-8"); // Or whatever encoding
}