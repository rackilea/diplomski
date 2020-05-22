static private int makeInt(byte b3, byte b2, byte b1, byte b0) {
    return (((b3       ) << 24) |
            ((b2 & 0xff) << 16) |
            ((b1 & 0xff) <<  8) |
            ((b0 & 0xff)      ));
}