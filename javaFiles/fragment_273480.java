public InputStream chunkInputStream(File file, int pos, int count) {
    FileChannel channel = FileChannel.open(file, READ);
    return new BoundedInputStream(
         Channels.newInputStream(channel.position(pos)), 
         count);
}