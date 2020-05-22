import java.nio.*;
...
ByteBuffer buf = ByteBuffer.wrap(audioBytes);
buf.order(ByteOrder.LITTLE_ENDIAN);

while (buf.remaining() >= 2) {
    short s = buf.getShort();
    double mono = (double) s;
    double mono_norm = mono / 32768.0;
    ...
}