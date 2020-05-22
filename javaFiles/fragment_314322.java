public static byte[] fromUnsignedInt(long value)
 {
     byte[] bytes = new byte[8];
     ByteBuffer.wrap(bytes).putLong(value);

     return Arrays.copyOfRange(bytes, 4, 8);
 }