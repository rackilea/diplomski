public static void main(String[] args) throws IOException {
  FileChannel fileChannel = FileChannel.open(Paths.get("JPPFConfiguration.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE);
  ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
  int n;
  long sum = 0L;
  while ((n = fileChannel.read(byteBuffer)) != -1) {
    sum += n;
    byteBuffer.flip();
    while (byteBuffer.hasRemaining()) {
      char c = (char) byteBuffer.get();
      System.out.print(c);
    }
    System.out.println("\n read " + n  + " bytes");
    byteBuffer.clear();
  }
  System.out.println("read " + sum + " bytes total");
}