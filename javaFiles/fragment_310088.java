// Class level
private static final Pattern TOKEN = Pattern.compile("\\S+");

// Instance level
{
    Matcher tokens = TOKEN.matcher(line);
    while (tokens.find())
        accessGroups.add(tokens.group());
}