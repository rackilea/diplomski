static long encodeXY(int x, int y) {
    return ((1L * x) << 32) | ((1L * y) & 0xFFFFFFFF);
}

static int decodeY(long value) {
    return (int)(value & 0xFFFFFFFF);
}

static int decodeX(long value) {
    return (int)(value >> 32);
}