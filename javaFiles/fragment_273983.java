public static void streamCopy(InputStream in, OutputStream out) throws IOException {
    byte[] buffer = new byte[32 * 1024]; // play with sizes..
    int readCount;
    while ((readCount = in.read(buffer)) != -1) {
        out.write(buffer, 0, readCount);
    }
}