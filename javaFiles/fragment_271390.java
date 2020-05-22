if (selector.select(TIMEOUT) == 0) {
  System.err.println("timeout");
  continue;
}

buffer.clear();
InetSocketAddress address = (InetSocketAddress) channel.receive(buffer);
buffer.flip();
String message = Charset.forName("ASCII").decode(buffer).toString();
System.err.format("From %s received: %s\n", address.getHostString(), message);
selector.selectedKeys().clear()