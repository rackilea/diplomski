int bufferSize = 20;
int bytesWritten = 0;
RandomAccessFile file = new RandomAccessFile("test.txt", "rw");
MappedByteBuffer buffer = file.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, bufferSize);

for (char c: "Line1".toCharArray()) {
    buffer.put((byte) c);
    bytesWritten++;
}
buffer.put((byte)
    '\n');
bytesWritten++;
for (char c: "Line2".toCharArray()) {
    buffer.put((byte) c);
    bytesWritten++;
}
buffer.force(); //make sure all is written before messing with truncating
file.getChannel().truncate(bytesWritten);