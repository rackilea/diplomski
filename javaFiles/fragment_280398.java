int crc32b(int crc) {
    ByteBuffer buf = ByteBuffer.allocate(4);
    buf.putInt(crc); // BIG_ENDIAN by default.
    buf.order(ByteOrder.LITTLE_ENDIAN);
    return buf.getInt(0);
}