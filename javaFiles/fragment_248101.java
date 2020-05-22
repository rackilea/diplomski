private void connect(SelectionKey key) throws IOException {
    SocketChannel channel = (SocketChannel) key.channel();
    try
    {
        if(!channel.finishConnect())
            System.out.println("* Here *");