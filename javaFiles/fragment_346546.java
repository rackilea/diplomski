public synchronized int read(short[] s, int off, int len) throws IOException {
    byte[] b = new byte[s.length * 2];
    int read = read(b, off * 2, len * 2);
    for (int i = 0; i < read; i+=2) {
        int b1 = b[i];
        int b2 = b[i+1];
        s[i/2] = (short) ((b1 << 8) | b2);
    }
    return read / 2;
}