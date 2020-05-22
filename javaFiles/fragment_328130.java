/**
 * Read till byteBuffer limit reached or received would-block.
 */
public boolean read(ByteBuffer byteBuffer) throws IOException {
    while (byteBuffer.hasRemaining()) {
        int len = socketChannel.read(byteBuffer);

        if (len == 0) {         
            // Got would-block.
            return false;
        }

        if (len < 0) {
            // Server has shutdown socket.
                throw new EOFException();
        }
    }
    return true;
}