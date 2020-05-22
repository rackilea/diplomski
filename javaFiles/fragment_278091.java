byte[] createBytes(Payload payload) {
    ByteByffer buffer = ByteBuffer.allocate(28).order(ByteOrder.LITTLE_ENDIAN);

    buffer.putInt(payload.time1);
    buffer.putInt(payload.time2);
    buffer.putInt(payload.time3);
    buffer.putInt(payload.time4);
    buffer.putInt(payload.time5);
    buffer.putInt(payload.time6);
    buffer.putByte(payload.speed1);
    buffer.putByte(payload.speed2);
    buffer.putByte(payload.speed3);
    buffer.putByte(0);
    return buffer.array();
}