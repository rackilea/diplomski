public static String plusOut(String input, String word) {

    StringBuilder builder = new StringBuilder();
    Pattern pattern = Pattern.compile(Pattern.quote(word));
    Matcher matcher = pattern.matcher(input);
    int start = 0;

    while(matcher.find()) {
        char[] replacement = new char[matcher.start() - start];
        Arrays.fill(replacement, '+');
        builder.append(new String(replacement)).append(word);
        start = matcher.end();
    }
    if(start < input.length()) {
        char[] replacement = new char[input.length() - start];
        Arrays.fill(replacement, '+');
        builder.append(new String(replacement));
    }

    return builder.toString();
}