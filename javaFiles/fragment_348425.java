private static final char[] hexDigit = {
    '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'
};
private static char toHex (int nibble) {
    return hexDigit[(nibble & 0xF)];
}