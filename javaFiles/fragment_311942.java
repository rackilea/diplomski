public static void reverseString(final String str) {
    final char[] chars = str.toCharArray();
    int start = 0;
    for (int i = 0; i < chars.length; i++) {
        if (chars[i] == ' ') {
            reverse(chars, start, i - 1);
            start = i + 1;
        }
    }
    reverse(chars, start, chars.length - 1);
    System.out.println(new String(chars));
}

private static void reverse(final char[] chars, int s, int e) {
    while (s < e) {
        final char t = chars[s];
        chars[s] = chars[e];
        chars[e] = t;
        s++;
        e--;
    }
}