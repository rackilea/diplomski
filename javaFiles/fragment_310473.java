protected static long copy(InputStream input, OutputStream output)
        throws IOException {
    byte[] buffer = new byte[4096]; 
    long count = 0L;
    int n = 0;
    while (-1 != (n = input.read(buffer))) {
        output.write(buffer, 0, n);
        count += n;
    }
    return count;
}