long result = getLong(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]);
System.out.println(result);
// Result:
// 11111111 11111101 11110111 10111111 11110011 10111111 01111111 00111111

long getLong(byte b7, byte b6, byte b5, byte b4, byte b3, byte b2, byte b1, byte b0) {
    return ((((long) b7       ) << 56) |
            (((long) b6 & 0xff) << 48) |
            (((long) b5 & 0xff) << 40) |
            (((long) b4 & 0xff) << 32) |
            (((long) b3 & 0xff) << 24) |
            (((long) b2 & 0xff) << 16) |
            (((long) b1 & 0xff) <<  8) |
            (((long) b0 & 0xff)      ));
}