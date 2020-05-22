byte[] arr = { 0x00, 0x01 };
ByteBuffer wrapped = ByteBuffer.wrap(arr); // big-endian by default
short num = wrapped.getShort(); // 1

ByteBuffer dbuf = ByteBuffer.allocate(2);
dbuf.putShort(num);
byte[] bytes = dbuf.array(); // { 0, 1 }