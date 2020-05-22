public static String readFromStandardNIO() {
    java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocate(20480000);
    try {
        ReadableByteChannel channel = Channels.newChannel(System.in);
        channel.read(buffer);
        channel.close();
    } catch (Exception e) {

    }
    return new String(buffer.array());
}