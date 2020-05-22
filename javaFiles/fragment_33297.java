public boolean tryAdvance(Consumer<? super byte[]> action) {
    byte[] bytes = new byte[this.bufferSize];
    int len = 0;
    try {
        for (int read; len < bytes.length; len += read)
            if ((read = this.is.read(bytes, len, bytes.length - len)) <= 0)
                break;
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
    if (len == 0)
        return false;
    if (len < bytes.length)
        bytes = Arrays.copyOfRange(bytes, 0, len);
    action.accept(bytes);
    return true;
}