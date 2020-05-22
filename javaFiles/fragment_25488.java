byte[] readFully(InputStream input) throws IOException {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    byte[] buffer = new byte[8 * 1024]; // 8K buffer
    int bytesRead;
    while ((bytesRead = input.read(buffer)) > 0) {
        output.write(buffer, 0, bytesRead);
    }
    return output.toByteArray();
}