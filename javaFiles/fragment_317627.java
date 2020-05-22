byte[] b = hexToBytes("007F80FF");

static byte[] hexToBytes(String s) {
    byte[] b = new byte[s.length() / 2];
    for (int i = 0; i < b.length; i++)
        b[i] = (byte)Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16);
    return b;
}