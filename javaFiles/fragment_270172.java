public static String fromCharCode(int... codePoints) {
    StringBuilder builder = new StringBuilder(codePoints.length);
    for (int codePoint : codePoints) {
        builder.append(Character.toChars(codePoint));
    }
    return builder.toString();
}