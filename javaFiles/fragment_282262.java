private static Pattern PATTERN = Pattern.compile("([^:]*:){2}[^:]*(?=:|$)");

public static String find(String input) {
    Matcher m = PATTERN.matcher(input);
    return m.find() ? m.group() : null;
}