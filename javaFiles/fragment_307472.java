private static final Pattern QUOTED = Pattern.compile("\"([^\"]+)\"");

// ...
public List<String> getQuotedWords(final String input)
{
    // Note: Java 7 type inference used; in Java 6, use new ArrayList<String>()
    final List<String> ret = new ArrayList<>();
    final Matcher m = QUOTED.matcher(input);
    while (m.find())
        ret.add(m.group(1));
    return ret;
}