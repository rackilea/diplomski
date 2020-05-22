ByteBuffer buf = ByteBuffer.allocate(48);
buf.clear();
buf.put("Hello!".getBytes());

buf.flip();

while(buf.hasRemaining()) {
    channel.write(buf);
}