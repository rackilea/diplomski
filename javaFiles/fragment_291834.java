ByteBuffer b = ByteBuffer.allocate(4);
//b.order(ByteOrder.BIG_ENDIAN); // optional, the initial order of a byte buffer is always BIG_ENDIAN.
b.putInt(0xFF95999F);

byte[] result = b.array();
fos.write(result);
...