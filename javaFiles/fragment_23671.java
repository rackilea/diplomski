private byte[] readChunkedData(InputStream stream, int size) throws IOException {
    byte[] buffer = new byte[size];
    DataInputStream din = new DataInputStream(stream);
    din.readFully(buffer);
    return buffer;
}