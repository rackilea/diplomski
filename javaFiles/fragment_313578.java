public String getStringFromBytes(byte[] inputBytes) {
    String s;
    s = new String(inputBytes);
    int zeroIndex = s.indexOf(0);
    return zeroIndex < 0 ? s : s.substring(0, zeroIndex);
}