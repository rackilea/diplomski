public synchronized int read(byte b[], int off, int len) throws IOException {
   // code removed
        int nread = read1(b, off + n, len - n);
   // code removed
}

private int read1(byte[] b, int off, int len) throws IOException {
   // code removed
            return getInIfOpen().read(b, off, len);
   // code removed
}