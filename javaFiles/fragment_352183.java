public long getBytesRead() {
    try {
        while (read() != -1)
            ;
    } catch (IOException e) {
        e.printStackTrace();
    }

    return bytesRead;
}