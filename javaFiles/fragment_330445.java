public static ByteBuffer readUnchecked(Path p) {
    try {
        return ByteBuffer.wrap(Files.readAllBytes(p));
    } catch(IOException ex) {
        throw new UncheckedIOException(ex);
    }
}