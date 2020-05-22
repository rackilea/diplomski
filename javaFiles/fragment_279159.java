private Float hex2float(String hexStr) {
    Float result = null;
    try {
        byte[] decodes = Hex.decodeHex(hexStr.toCharArray());
        result = getFloat(decodes, 0);
    } catch (DecoderException e) {
        // log error
    }
    return result;
}

private float getFloat(byte[] b, int index) {
    int l;
    l = b[index + 0];
    l &= 0xff;
    l |= ((long) b[index + 1] << 8);
    l &= 0xffff;
    l |= ((long) b[index + 2] << 16);
    l &= 0xffffff;
    l |= ((long) b[index + 3] << 24);
    return Float.intBitsToFloat(l);
}