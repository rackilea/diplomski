ByteBuffer buf = ByteBuffer.allocate(500);
buf.putInt(1);
...
...
byte[] a = new byte[buf.position()];
buf.rewind();
buf.get(a);