byte[] parse(char[] hex) {
    int len = hex.length;
    if (len % 2 != 0) {
        throw new IllegalArgumentException(
            "Even number of digits required");
    }

    byte[] bytes = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        int high = Character.digit(hex[i], 16);
        int low = Character.digit(hex[i + 1], 16);
        bytes[i / 2] = (byte) (high << 4 | low);
    }

    return bytes;
}