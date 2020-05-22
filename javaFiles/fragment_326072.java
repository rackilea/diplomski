public long[] fast_str_to_a32(String string) throws UnsupportedEncodingException {
    if (string.length() % 4 != 0) {
        string += new String(new char[4 - string.length() % 4]);
    }
    long[] data = new long[string.length() / 4];

    byte[] bytes = string.getBytes("ISO-8859-1");

    byte[] part = new byte[8];
    ByteBuffer bb = ByteBuffer.wrap(part); 
    for (int k = 0, i = 0; i < bytes.length; i += 4, k++) {
        System.arraycopy(bytes, i, part, 4, 4);
        bb.rewind();
        data[k] = bb.getLong();
    }
    return data;
}