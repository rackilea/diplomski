final Path path = Paths.get("path/to/wanted/file");

try (
    final FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
) {
    final int bufsize = ((int) channel.size() + 7) & ~7;
    final ByteBuffer buf = ByteBuffer.allocate(bufsize);
    channel.read(buf);
    return buf.array();
}