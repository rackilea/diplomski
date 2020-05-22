Pattern regex = Pattern.compile(
    "(?<=x:) # Assert position right after 'x:'\n" +
    "[^:]*   # Match any number of characters except colons", 
    Pattern.COMMENTS);
Matcher regexMatcher = regex.matcher(subjectString);
if (regexMatcher.find()) {
    ResultString = regexMatcher.group();
}