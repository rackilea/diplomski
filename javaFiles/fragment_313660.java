public static long stream(InputStream input, OutputStream output) throws IOException {
    try (
        ReadableByteChannel inputChannel = Channels.newChannel(input);
        WritableByteChannel outputChannel = Channels.newChannel(output);
    ) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(10240);
        long size = 0;

        while (inputChannel.read(buffer) != -1) {
            buffer.flip();
            size += outputChannel.write(buffer);
            buffer.clear();
        }

        return size;
    }
}