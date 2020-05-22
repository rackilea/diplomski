private static final Pattern PATTERN = Pattern.compile("[^,]*");

private static void splitInside(String string) {
    Matcher matcher = PATTERN.matcher(string);
    while (matcher.find()) {
        System.out.print(matcher.group());
    }
    System.out.println();
}