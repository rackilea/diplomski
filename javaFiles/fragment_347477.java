private static final long TIMEOUT = 500;

/**
 * Method receives the Server Response
 */
public <C extends SelectableChannel & ReadableByteChannel>byte[]
receive(C chan) throws IOException
{
    logger.debug(TAG + " Client Recieving...");
    try
    {
        Selector sel = Selector.open();
        SelectionKey key = chan.register(sel, SelectionKey.OP_READ);
        ByteBuffer inputData = ByteBuffer.allocate(1024);
        long timeout = TIMEOUT;
        while (inputData.hasRemaining()) {
            if (timeout < 0L) {
                throw new IOException(String.format("Timed out, %d of %d bytes read", inputData.position(), inputData.limit()));
            }
            long startTime = System.nanoTime();
            sel.select(timeout);
            long endTime = System.nanoTime();
            timeout -= TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
            if (sel.selectedKeys().contains(key)) {
                chan.read(inputData);
            }
            sel.selectedKeys().clear();
        }
        return inputData.array();
    } catch (Exception e)
    {
        throw new Exception(TAG + " Couldnt receive data from modem: " + e.getMessage());
    }
}