try {
    AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
    Future<Void> futureConnect = channel.connect(new InetSocketAddress("www.yahoo.com", 80));
    // wait until connected
    futureConnect.get();
    System.out.println("Connected");

    ByteBuffer buffer = ByteBuffer.wrap("GET http://www.yahoo.com HTTP/1.1\r\n\r\n".getBytes());
    Future<Integer> futureWrite = channel.write(buffer);
    // wait until all data is written
    Integer resultWrite = futureWrite.get();
    System.out.println("Write completed: " + resultWrite.toString());

    ByteBuffer bufferRead = ByteBuffer.allocate(23);
    Future<Integer> futureRead = channel.read(bufferRead);
    // wait ...
    Integer resultRead = futureRead.get();
    System.out.println("Read completed: " + resultRead.toString());
    System.out.println(new String(bufferRead.array()));

    // finnished now the channel can be closed
    channel.close();
} catch (Exception e) {
    e.printStackTrace();
}