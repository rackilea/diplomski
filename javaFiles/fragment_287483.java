package java.nio;

/**
 *
 * @author Aleksandr Dubinsky
 */
public class BufferUtils {

      public static ByteBuffer
    asByteBuffer (FloatBuffer floatBuffer) {

            if (floatBuffer instanceof DirectFloatBufferU)
            {
                DirectFloatBufferU buffer = (DirectFloatBufferU) floatBuffer;
                return (ByteBuffer) new DirectByteBuffer (buffer.address(), floatBuffer.capacity() * Float.BYTES, buffer)
                                            .position (floatBuffer.position() * Float.BYTES)
                                            .limit (floatBuffer.limit() * Float.BYTES);
            }
            else if (floatBuffer instanceof DirectFloatBufferS)
            {
                DirectFloatBufferS buffer = (DirectFloatBufferS) floatBuffer;
                return (ByteBuffer) new DirectByteBuffer (buffer.address(), floatBuffer.capacity() * Float.BYTES, buffer)
                                            .position (floatBuffer.position() * Float.BYTES)
                                            .limit (floatBuffer.limit() * Float.BYTES);
            }
            else if (floatBuffer instanceof ByteBufferAsFloatBufferB)
            {
                ByteBufferAsFloatBufferB buffer = (ByteBufferAsFloatBufferB)floatBuffer;
                return (ByteBuffer) ((ByteBuffer) buffer.bb
                                                        .duplicate()
                                                        .position (buffer.offset)
                                                        .limit (buffer.offset + buffer.capacity() * Float.BYTES))
                                                        .slice()
                                                        .position (buffer.position() * Float.SIZE)
                                                        .limit (buffer.limit() * Float.BYTES);
            }
            else if (floatBuffer instanceof ByteBufferAsFloatBufferL)
            {
                ByteBufferAsFloatBufferL buffer = (ByteBufferAsFloatBufferL)floatBuffer;
                return (ByteBuffer) ((ByteBuffer) buffer.bb
                                                        .duplicate()
                                                        .position (buffer.offset)
                                                        .limit (buffer.offset + buffer.capacity() * Float.BYTES))
                                                        .slice()
                                                        .position (buffer.position() * Float.SIZE)
                                                        .limit (buffer.limit() * Float.BYTES);
            }
            else
                throw new IllegalArgumentException ("Unsupported implementing class " + floatBuffer.getClass().getName());
        }

}