// Note the alternation
private static final Pattern PATTERN 
    = Pattern.compile("\\$[^.$]+(\\.[^.$]+)*\\$|[^.]+");

//

public List<String> matchesForInput(final String input)
{
    final Matcher m = PATTERN.matcher(input);
    final List<String> matches = new ArrayList<>();

    while (m.find())
        matches.add(m.group());

    return matches;
}