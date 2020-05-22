ByteBuffer iLength = ByteBuffer.allocate(4);
iLength.order(ByteOrder.LITTLE_ENDIAN);
iLength.putInt(length);
output.write(iLength.array(), 0, 4);
output.write(buffer);
output.flush();