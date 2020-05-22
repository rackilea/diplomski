public static boolean tryWriteBinarySTL(Triangle t, ByteBuffer buf) {
    final int triangleBytes = 50; // set this.
    if (buf.remaining() < triangleBytes) {
       return false;
    }

    buf.putFloat((float)t.normal.x);
    // ...
    return true;
}

// Create a new path to your file on the default file system.
Path filePath = Paths.get("file.txt");

// Open a channel in write mode on your file.
try (WritableByteChannel channel = Files.newByteChannel(filePath, StandardOpenOption.WRITE)) {
    // Allocate a new buffer.
    ByteBuffer buf = ByteBuffer.allocate(8192);

    // Write your triangle data to the buffer.
    for (Triangle triangle : triangles) {
        while (!tryWriteBinarySTL(triangle, buf) ) {
            // Flush buffer.
            buf.flip();
            while (buf.hasRemaining()) {
                channel.write(buf);
            }

            buf.flip();
        }
    }

    // Write remaining.
    buf.flip();
    channel.write(buf);
}