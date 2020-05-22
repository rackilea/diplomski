private static byte[] toFourBytes(byte i) {
    byte[] buf = new byte[4];
    int bytePos = 4;
    do {
        buf[--bytePos] = i & 0x3;
        i >>>= 2;
    } while (i != 0);
    return buf;
 }