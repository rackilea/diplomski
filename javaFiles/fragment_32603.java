public static byte[] toBytes(String str) {
    char[] src = str.toCharArray();
    int len = src.length;
    byte[] buff = new byte[len];
    for (int i=0; i<len; ++i) {
        buff[i] = (byte)src[i];
    }
    return buff;
}