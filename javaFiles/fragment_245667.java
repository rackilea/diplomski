/**
 * Measures the content length using the given InputStream
 * 
 * Usage: inputStream = printResponseLength(inputStream);
 * 
 * @param is the InputStream to measure the content length for
 * @return a copy of the InputStream for further reading
 * @throws Exception if the stream cannot be read
 */
private InputStream printResponseLength(InputStream is) throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int len;
    while ((len = is.read(buffer, 0, buffer.length)) != -1) {
        baos.write(buffer, 0, len);
    }
    baos.flush();

    System.out.println("Content-Length: "+baos.toByteArray().length);

    return new ByteArrayInputStream(baos.toByteArray());
}