public static byte[] readFully(InputStream stream) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buffer = new byte[16 * 1024];
    int bytesRead;
    while ((bytesRead = stream.read(buffer)) > 0) {
        baos.write(buffer, 0, bytesRead);
    }
    return baos.toByteArray();
}