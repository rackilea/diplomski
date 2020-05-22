private String getString(ByteBuffer byteBuffer) {
    byte[] bytes = new byte[byteBuffer.remaining()];
    byteBuffer.get(bytes);
    return new String(bytes);
}

private ByteBuffer getByteBuffer(String string) {
    byte[] bytes = java.util.Base64.getDecoder().decode(string);
    ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
    byteBuffer.put(bytes);
    byteBuffer.flip();

    return byteBuffer;
}