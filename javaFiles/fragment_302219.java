public static String decode(final String morseCode) {
    final Matcher matcher = pattern.matcher(morseCode);

    final StringBuilder builder = new StringBuilder();
    while(matcher.find()) {
        builder.append(getLetter(matcher.group().trim()));
    }

    return builder.toString();
}