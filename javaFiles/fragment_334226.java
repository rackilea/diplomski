Path path = Paths.get("I://music - Copy.mp3");

System.out.println(Files.size(path)/1024 + "KB");

// pick either:
try (FileChannel chan = FileChannel.open(path, StandardOpenOption.WRITE)) {
try (SeekableByteChannel chan = Files.newByteChannel(path, StandardOpenOption.WRITE)) {
    chan.position(1024 * 1024);

    ByteBuffer b = ByteBuffer.allocate(1024);
    chan.write(b);

    System.out.println("Write 1KB of data");
}

System.out.println(Files.size(path)/1024 + "KB");