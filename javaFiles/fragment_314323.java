public static long toUnsignedInt(byte[] bytes)
 {
     ByteBuffer buffer = ByteBuffer.allocate(8).put(new byte[]{0, 0, 0, 0}).put(bytes);
     buffer.position(0);

     return buffer.getLong();
 }