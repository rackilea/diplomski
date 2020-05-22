/** Simple split parser */
static class SplitParser implements Parser {
    public String parse(String line) {
        String[] fields = line.split("\\t");
        if (fields.length == 4) {
            return fields[2];
        }
        return null;
    }
}

/** Split parser, but with compiled pattern */
static class CompiledSplitParser implements Parser {
    private static final String regex = "\\t";
    private static final Pattern pattern = Pattern.compile(regex);

    public String parse(String line) {
        String[] fields = pattern.split(line);
        if (fields.length == 4) {
            return fields[2];
        }
        return null;
    }
}

/** Regex group parser */
static class RegexParser implements Parser {
    private static final String regex = "(?:[^\\t]*)\\t(?:[^\\t]*)\\t([^\\t]*)\\t(?:[^\\t]*)";
    private static final Pattern pattern = Pattern.compile(regex);

    public String parse(String line) {
        Matcher m = pattern.matcher(line);
        if (m.matches()) {
            return m.group(1);
        }
        return null;
    }
}