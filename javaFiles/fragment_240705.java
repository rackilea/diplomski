SocketChannel socketChannel;

byte[] outData;

final static int MAX_OUTPUT = 1024;

ByteBuffer output = ByteBuffer.allocate(MAX_OUTPUT);

// if message was not written fully
if (socketChannel.write(output) < messageSize()) {

// register interest for write event
SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_WRITE); 
        selectionKey.attach(writeHandler);
        selector.wakeup();