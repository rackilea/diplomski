static byte[] readExactly(InputStream input, int size) throws IOException {
    byte[] data = new byte[size];
    readExactly(input, data);
    return data;
}

static void readExactly(InputStream input, byte[] data) throws IOException {
    int index = 0;
    while (index < data.length) {
        int bytesRead = input.read(data, index, data.length - index);
        if (bytesRead < 0) {
            throw new EOFException("Expected more data");
        }
    }
}