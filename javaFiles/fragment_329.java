final int count = 220000000;

final FileChannel channel = new RandomAccessFile("abc.txt", "rw").getChannel();
MappedByteBuffer mbb = channel.map(FileChannel.MapMode.READ_WRITE, 0, count * 8);
mbb.order(ByteOrder.nativeOrder());

long start = System.nanoTime();
for (int i = 0; i < count; i++) {
    long l = i;
    mbb.putLong(l);
}
channel.close();
long time = System.nanoTime() - start;
System.out.printf("Took %.3f seconds to write %,d longs%n",
        time / 1e9, count);

// Only works on Sun/HotSpot/OpenJDK to deallocate buffer.
((DirectBuffer) mbb).cleaner().clean();

final FileChannel channel2 = new RandomAccessFile("abc.txt", "r").getChannel();
MappedByteBuffer mbb2 = channel2.map(FileChannel.MapMode.READ_ONLY, 0, channel2.size());
mbb2.order(ByteOrder.nativeOrder());
assert mbb2.remaining() == count * 8;
long start2 = System.nanoTime();
for (int i = 0; i < count; i++) {
    long l = mbb2.getLong();
    if (i != l)
        throw new AssertionError("Expected "+i+" but got "+l);
}
channel.close();
long time2 = System.nanoTime() - start2;
System.out.printf("Took %.3f seconds to read %,d longs%n",
        time2 / 1e9, count);

// Only works on Sun/HotSpot/OpenJDK to deallocate buffer.
((DirectBuffer) mbb2).cleaner().clean();