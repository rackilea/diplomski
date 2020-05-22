private static byte[] toFourBytes(byte i) {
    byte[] buf = new byte[4];
    int bytePos = 4;
    do {
        byte temp = i & 0x1;
        i >>>= 1;
        buf[--bytePos] = ((i & 0x1) << 4) | temp;
        i >>>= 1;
    } while (i != 0);
    return buf;
 }