ByteBuffer b = ByteBuffer.allocate(4);

b.put(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1});

b.flip();

System.out.println(b.getInt());

>> 1