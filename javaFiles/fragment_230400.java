long[] byteToLong(byte[] array) {
     ByteBuffer byteBuffer = ByteBuffer.wrap(array);
     LongBuffer longBuffer = byteBuffer.asLongBuffer();
     long[] result = new long[longBuffer.capacity()];
     longBuffer.get(result);
     return result;
}