ByteBuf buf = ...
byte[] bytes;
int offset;
int length = buf.readableBytes();

if (buf.hasArray()) {
    bytes = buf.array();
    offset = buf.arrayOffset();
} else {
    bytes = new byte[length];
    buf.getBytes(buf.readerIndex(), bytes);
    offset = 0;
}