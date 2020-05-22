protected static int putLong(byte [] b, int off, long val) {
    b[off + 7] = (byte) (val >> 0);
    b[off + 6] = (byte) (val >> 8);
    b[off + 5] = (byte) (val >> 16);
    b[off + 4] = (byte) (val >> 24);
    b[off + 3] = (byte) (val >> 32);
    b[off + 2] = (byte) (val >> 40);
    b[off + 1] = (byte) (val >> 48);
    b[off + 0] = (byte) (val >> 56);
    return off + 8;
}