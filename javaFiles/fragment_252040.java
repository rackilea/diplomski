public static String trimChars(String source, String trimChars) {
    char[] chars = source.toCharArray();
    int length = chars.length;
    int start = 0;

    while (start < length && trimChars.indexOf(chars[start]) > -1) {
        start++;
    }

    while (start < length && trimChars.indexOf(chars[length - 1]) > -1) {
        length--;
    }

    if (start > 0 || length < chars.length) {
        return source.substring(start, length);
    } else {
        return source;
    }
}