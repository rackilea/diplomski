static class RegexParser implements Parser {
    private static final String regex = "(?:[^\\t]*)\\t(?:[^\\t]*)\\t([^\\t]*)\\t(?:[^\\t]*)";
    private static final Pattern pattern = Pattern.compile(regex);

    // Matcher is not thread-safe...
    private Matcher matcher = pattern.matcher("");

    // ... so this method is no-longer thread-safe
    public String parse(String line) {
        matcher = matcher.reset(line);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }
}