public InputStream getInputStream(final Path path)
    throws IOException
{
    final ByteBuffer buf = ByteBuffer.allocate(HEADER_SIZE);
    final FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
    channel.read(buf);
    return Channels.newInputStream(channel);
}