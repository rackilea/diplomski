try (SeekableByteChannel ch = Files.newByteChannel(Paths.get("test.txt"))) {
    ByteBuffer bb = ByteBuffer.allocateDirect(1000);
    for(;;) {
        StringBuilder line = new StringBuilder();
        int n = ch.read(bb);
        // add chars to line
        // ...
    }
}