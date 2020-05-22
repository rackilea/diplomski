boolean foundMatch = false;
try {
    Pattern regex = Pattern.compile("\\b(?:(https?|ftp|file)://|www\\.)?[-A-Z0-9+&#/%?=~_|$!:,.;]*[A-Z0-9+&@#/%=~_|$]\\.[-A-Z0-9+&@#/%?=~_|$!:,.;]*[A-Z0-9+&@#/%=~_|$]", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
    Matcher regexMatcher = regex.matcher(subjectString);
    foundMatch = regexMatcher.matches();
} catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
}