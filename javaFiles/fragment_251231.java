int size = readInt();
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    int nRead = 0;
    int totalRead = 0;
    byte[] data = new byte[1024];

    while (totalRead < size) {
        int read;
        if (data.length <= (size - totalRead))
            read = data.length;
        else
            read = (size - totalRead);
        if ((nRead = inputStream.read(data, 0, read)) == -1)
            throw new IOException("End of stream");
        buffer.write(data, 0, nRead);
        totalRead += nRead;
    }