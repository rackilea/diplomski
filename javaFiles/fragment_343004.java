private static String toHex(byte[] array) {
    BigInteger bi = new BigInteger(1, array);
    String hex = bi.toString(16);
    int paddingLength = (array.length * 2) - hex.length();
    if(paddingLength > 0)
        return String.format("%0" + paddingLength + "d", 0) + hex;
    else
        return hex;
}