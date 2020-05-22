Path path=Paths.get(System.getProperty("user.home")).resolve("desktop/text.txt");
try(FileChannel channel=FileChannel.open(path)) {
  ByteBuffer buffer = ByteBuffer.allocate(128);
  while(channel.read(buffer)!=-1) {
    buffer.flip();
    while(buffer.hasRemaining())
        System.out.printf("%02x ", buffer.get());
    buffer.clear();
    System.out.println();
  }
} catch (IOException e) {
    System.out.println(e.toString());
}