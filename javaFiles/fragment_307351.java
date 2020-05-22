// to read the byteBuffer from the beginning, you might want to rewind
// before copying it to an array:
// byteBuffer.rewind();
byte[] array = new byte[byteBuffer.remaining()];
byteBuffer.get(array);
DataInputStream ds = new DataInputStream(new ByteArrayInputStream(array));