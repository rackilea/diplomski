/**
 * writes all bytes from inputStream to outputStream
 * @param source
 * @param destination
 * @throws IOException
 */
public static void pipeStreams(java.io.InputStream source, java.io.OutputStream destination) throws IOException {

    // 1kb buffer
    byte [] buffer = new byte[1024];
    int read = 0;
    while((read=source.read(buffer)) != -1) {
        destination.write(buffer, 0, read);
    }
    destination.flush();
}