Buffer outputBuffer = library.getBuffer();
ByteBuffer byteBuffer;
if (outputBuffer instanceof ByteBuffer) {
    byteBuffer = (ByteBuffer) outputBuffer;
} else if (outputBuffer instanceof CharBuffer) {
    byteBuffer = ByteBuffer.allocate(outputBuffer.capacity());
    byteBuffer.asCharBuffer().put((CharBuffer) outputBuffer);
} else if (outputBuffer instanceof ShortBuffer) {
    byteBuffer = ByteBuffer.allocate(outputBuffer.capacity() * 2);
    byteBuffer.asShortBuffer().put((ShortBuffer) outputBuffer);
} else if (outputBuffer instanceof IntBuffer) {
    byteBuffer = ByteBuffer.allocate(outputBuffer.capacity() * 4);
    byteBuffer.asIntBuffer().put((IntBuffer) outputBuffer);
} else if (outputBuffer instanceof LongBuffer) {
    byteBuffer = ByteBuffer.allocate(outputBuffer.capacity() * 8);
    byteBuffer.asLongBuffer().put((LongBuffer) outputBuffer);
} else if (outputBuffer instanceof FloatBuffer) {
    byteBuffer = ByteBuffer.allocate(outputBuffer.capacity() * 4);
    byteBuffer.asFloatBuffer().put((FloatBuffer) outputBuffer);
} else if (outputBuffer instanceof DoubleBuffer) {
    byteBuffer = ByteBuffer.allocate(outputBuffer.capacity() * 8);
    byteBuffer.asDoubleBuffer().put((DoubleBuffer) outputBuffer);
}