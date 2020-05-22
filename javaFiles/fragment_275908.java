public static void main(String [] args) throws IOException {
    String str = "foo";

    SeekableByteChannel channel = Files.newByteChannel(Paths.get("C:\\tmp\\foo.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    for(int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        buffer.put((byte)(ch >> 8));
        buffer.put((byte)ch);
    }
    buffer.flip();
    channel.write(buffer);

    RandomAccessFile file = new RandomAccessFile("/tmp/foo.txt", "rw");
    try {
        while(true) {
            System.out.println(file.readChar());
        }
    } finally {
        file.close();
    }
}