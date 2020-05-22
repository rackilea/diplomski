public class ProtocolDataInputStream extends InputStream {
    private BlockingQueue<byte[]> nextChunks = new ArrayBlockingQueue<byte[]>(100);
    private byte[] currentChunk = null;
    private int currentChunkOffset = 0;
    private boolean noMoreChunks = false;

    @Override
    public synchronized int read() throws IOException {
        boolean takeNextChunk = currentChunk == null || currentChunkOffset >= currentChunk.length;
        if (takeNextChunk) {
            if (noMoreChunks) {
                // stream is exhausted
                return -1;
            } else {
                currentChunk = nextChunks.take();
                currentChunkOffset = 0;
            }
        }
        return currentChunk[currentChunkOffset++];
    }

    @Override
    public synchronized int available() throws IOException {
        if (currentChunk == null) {
            return 0;
        } else {
            return currentChunk.length - currentChunkOffset;
        }
    }

    public synchronized void addChunk(byte[] chunk, boolean chunkIsLast) {
        nextChunks.add(chunk);
        if (chunkIsLast) {
            noMoreChunks = true;
        }
    }
}