int blockSize = 32 * 1024;
ByteBuffer bb = ByteBuffer.allocateDirect(blockSize);
FileChannel out = new FileOutputStream("deleteme.dat").getChannel();
for (int i = 0; i < (1024 << 20); i += blockSize) {
    bb.clear();
    while (bb.remaining() > 0)
        if (out.write(bb) < 1) throw new AssertionError();
}
out.close();

long start = System.nanoTime();
FileChannel in = new FileInputStream("deleteme.dat").getChannel();
MappedByteBuffer map = in.map(FileChannel.MapMode.READ_ONLY, 0, in.size());
in.close();
long end = System.nanoTime();
System.out.printf("Mapped file at a rate of %.1f MB/s%n",
        1024 * 1e9 / (end - start));