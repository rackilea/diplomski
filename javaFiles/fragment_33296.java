public final class ChunkingInputStreamSpliterator implements Spliterator<byte[]> {

    private final InputStream is;
    private final int bufferSize;

    public ChunkingInputStreamSpliterator(InputStream is, int bufferSize) {
        this.is = is;
        this.bufferSize = bufferSize;
    }

    @Override
    public boolean tryAdvance(Consumer<? super byte[]> action) {
        byte[] bytes;
        try {
            bytes = this.is.readNBytes(this.bufferSize);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        if (bytes.length == 0)
            return false;
        action.accept(bytes);
        return true;
    }

    @Override
    public Spliterator<byte[]> trySplit() {
        return null; // cannot split an InputStream
    }

    @Override
    public long estimateSize() {
        return Long.MAX_VALUE; // unknown
    }

    @Override
    public int characteristics() {
        return Spliterator.ORDERED | Spliterator.NONNULL;
    }

}