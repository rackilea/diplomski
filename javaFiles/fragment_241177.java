String convertLatinLikeToAscii(String text) {
    char[] chars = text.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        char c = chars[i];
        if (c >= 0xff01 && c <= 0xff5e) {
            // Map U+FF01 to U+0021 etc
            chars[i] = (char) (c - (0xff01 - 0x21));
        }
    }
    return new String(chars);
}