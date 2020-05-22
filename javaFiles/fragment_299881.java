static UUID toUUID(byte[] bytes) {
    if (bytes.length != 16) {
        throw new IllegalArgumentException();
    }
    int i = 0;
    long msl = 0;
    for (; i < 8; i++) {
        msl = (msl << 8) | (bytes[i] & 0xFF);
    }
    long lsl = 0;
    for (; i < 16; i++) {
        lsl = (lsl << 8) | (bytes[i] & 0xFF);
    }
    return new UUID(msl, lsl);
}
UUID artID = toUUID(artIDArr);