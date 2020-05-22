// Necessary in order to convert negative shorts!
private static final int USHORT_MASK = (1 << 16) - 1;

final ByteBuffer buf = ByteBuffer.wrap(audioSamples)
    .order(ByteOrder.LITTLE_ENDIAN);
final ByteBuffer newBuf = ByteBuffer.allocate(audioSamples.length)
    .order(ByteOrder.LITTLE_ENDIAN);

int sample;

while (buf.hasRemaining()) {
    sample = (int) buf.getShort() & USHORT_MASK;
    sample *= volume;
    newBuf.putShort((short) (sample & USHORT_MASK));
}

return newBuf.array();