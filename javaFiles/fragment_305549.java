final protected static char[] decimalArray = "0123456789".toCharArray();
public static String bytesToDecimal(byte[] bytes) {
    char[] decimalChars = new char[bytes.length * 4];
    for ( int j = 0; j < bytes.length; j++ ) {
        int v = bytes[j] & 0xFF;
        decimalChars[j * 4] = decimalArray[v / 100];
        decimalChars[j * 4 + 1] = decimalArray[(v / 10) % 10];
        decimalChars[j * 4 + 2] = decimalArray[v % 10];
        decimalChars[j * 4 + 3] = ' ';
    }
    return new String(decimalChars);
}