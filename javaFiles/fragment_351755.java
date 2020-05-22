static String toHex2(BigInteger bi) {
    String hex = bi.toString(16).toUpperCase();
    if (hex.length() % 2 == 1) {
        return "0" + hex;
    } else {
        return hex;
    }
}