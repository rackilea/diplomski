while(iterator.hasNext())
{
    SelectionKey key = iterator.next();

    channel.receive(buffer);     // The buffer is a ByteBuffer.
    buffer.flip();
    byte[] bytes = new byte[buffer.limit()];  // copy buffer contents to an array
    buffer.get(bytes);
    // thread will convert byte array to String
    new Thread(new ThreadToPrintTheMessage(bytes)).start();

    buffer.clear();

    iterator.remove();
}