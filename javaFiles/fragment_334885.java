private static long getUnsigned(final byte b) {
    if (b < 0) {
        return (long) b + 256;
    }
    return b;
}