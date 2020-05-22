List<String> matchList = new ArrayList<String>();
Pattern regex = Pattern.compile(
    "(?:           # Start of group, matching...\n" +
    " \\\\\"       # an escaped quote\n" +
    " [^\"\\\\]*   # followed by 0+ characters except backslashes or quotes\n" +
    " \\\\\"       # and another escaped quote\n" +
    "|             # OR\n" +
    " [^\\s\\\\\"] # a character except spaces, backslashes or quotes.\n" +
    ")+            # Repeat as many times as possible (at least once)", 
    Pattern.COMMENTS);
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    matchList.add(regexMatcher.group());
}