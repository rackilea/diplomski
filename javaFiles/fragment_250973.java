byte[] data = DatatypeConverter.parseHexBinary(str);
ByteBuffer buffer = ByteBuffer.wrap(data);

buffer.order(ByteOrder.LITTLE_ENDIAN); // maybe!

short id = buffer.getShort();
int ssn = buffer.getInt();
long number = buffer.getLong();