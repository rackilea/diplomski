Selector selector = Selector.open();

int[] ports = {4000,4001,6000};

for (int port : ports) {
   ServerSocketChannel server = ServerSocketChannel.open();
   server.configureBlocking(false);

   server.socket().bind(new InetSocketAddress(port));
// we are only interested when accept evens occur on this socket
   server.register(selector, SelectionKey.OP_ACCEPT); 
}

while (selector.isOpen()) {
   selector.select();
   Set readyKeys = selector.selectedKeys();
   Iterator iterator = readyKeys.iterator();
   while (iterator.hasNext()) {
      SelectionKey key = (SelectionKey) iterator.next();
      if (key.isAcceptable()) {
         SocketChannel client = server.accept();
         Socket socket = client.socket();
// create new thread to deal with connection (closing both socket and client when done)
      }
   }
}

// tidy up selector and channels