public static void parse(String input) {
    String KV_REGEX = "(\"[^\" ]*\"|[^{=, ]*) *= *(\"[^\"]*\"|[^=,) }]*)";
    Pattern KV_PATTERN = Pattern.compile(KV_REGEX);

    Matcher matcher = KV_PATTERN.matcher(input);

    System.out.println("\nMatcher groups discovered:");

    while (matcher.find()) {
        System.out.println(matcher.group(1) + ", " + matcher.group(2));
    }
}