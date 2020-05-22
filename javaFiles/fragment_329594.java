public static void writeBinarySTL(Triangle t, ByteBuffer buf) {
    buf.putFloat((float)t.normal.x);
    // ...
}

// Create a new path to your file on the default file system.
Path filePath = Paths.get("file.txt");

// Open a channel in write mode on your file.
try (WritableByteChannel channel = Files.newByteChannel(filePath, StandardOpenOption.WRITE)) {
    // Allocate a new buffer.
    ByteBuffer buf = ByteBuffer.allocate(8192);

    // Write your triangle data to the buffer.
    writeBinarySTL(t, buf);

    // Flip from write mode to read mode.
    buf.flip();

    // Write your buffer's data.
    channel.write(buf);
}