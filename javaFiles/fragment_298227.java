long a = 5324565343L;
    long b = 423456L;
    byte[] bytes = new byte[18];
    ByteBuffer buffer = ByteBuffer.wrap(bytes);
    buffer.putLong(a);
    buffer.putChar('-');
    buffer.putLong(b);