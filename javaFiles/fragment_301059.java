ByteBuffer buf = ByteBuffer.allocate(floats*4);
FloatBuffer floats = buf.asFloatBuffer();
floats.put(5.5f);
...
ServerSocket server = new ServerSocket(38300);
SocketChannel sc = server.accept().getChannel();
sc.write(buf);