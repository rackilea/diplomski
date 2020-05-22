private static int parseBinaryString(String s) {
    int binary = 0;
    for (int i = s.length() - 1, c; i >= 0; i--) {
        binary <<= 1;
        c = s.charAt(i);
        if (c == '1') {
            binary++;
        } else if (c != '0') {
            throw new NumberFormatException(s);
        }
    }
    return binary;
}