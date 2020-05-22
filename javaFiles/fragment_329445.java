InetAddress serverIPAddress = InetAddress.getByName("localhost");
InetSocketAddress serverAddress = new InetSocketAddress(
    serverIPAddress, 19000);
Selector selector = Selector.open();
SocketChannel channel = SocketChannel.open();
channel.configureBlocking(false);
channel.connect(serverAddress);
int operations = SelectionKey.OP_CONNECT | SelectionKey.OP_READ
    | SelectionKey.OP_WRITE;
channel.register(selector, operations);

while (true) {
  if (selector.select() > 0) {
    Set keys = selector.selectedKeys();
    ...
  }
}
channel.close();