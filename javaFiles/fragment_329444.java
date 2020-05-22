InetAddress hostIPAddress = InetAddress.getByName("localhost");
int port = 19000;
Selector selector = Selector.open();
ServerSocketChannel channel = ServerSocketChannel.open();
channel.configureBlocking(false);
channel.socket().bind(new InetSocketAddress(hostIPAddress, port));
channel.register(selector, SelectionKey.OP_ACCEPT);

while (true) {
  Set keys = selector.selectedKeys();
  ...
}