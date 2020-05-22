private String pack(int value, int allocateBytes, ByteOrder byteOrder, String charsetName) throws UnsupportedEncodingException {
    ByteBuffer buf = ByteBuffer.allocate(allocateBytes);
    buf.order(byteOrder);
    byte[] bytes = buf.putInt(value).array();
    String result = new String(bytes, charsetName);
    return result;
}