List<String> matchList = new ArrayList<String>();
Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    if (regexMatcher.group(1) != null) {
        // Add double-quoted string without the quotes
        matchList.add(regexMatcher.group(1));
    } else if (regexMatcher.group(2) != null) {
        // Add single-quoted string without the quotes
        matchList.add(regexMatcher.group(2));
    } else {
        // Add unquoted word
        matchList.add(regexMatcher.group());
    }
}