private byte[] read() throws Exception{
    byte[] bytes = new byte[8192];
    int read = this.in.read(bytes);
    if (read <= 0) return new byte[0]; // or return null, or something, read might be -1 when there was no data.
    byte[] readBytes = new byte[read]
    System.arraycopy(bytes, 0, readBytes, 0, read)
    return readBytes;
}