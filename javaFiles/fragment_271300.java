ByteBuffer buffer = ByteBuffer.allocate(Byte.SIZE);
buffer.put(0, (byte) 255);
buffer.put(1, (byte) 253);
// ...
buffer.put(7, (byte)  63);
System.out.println(buffer.getLong());