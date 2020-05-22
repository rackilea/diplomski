try {
    Pattern regex = Pattern.compile("(?:\\d+\\s*)+");
    Matcher regexMatcher = regex.matcher(contactText);
    if (regexMatcher.find()) {
        phoneLabel.setText(regexMatcher.group(0));
    }
} catch (PatternSyntaxException ex) {
    // Syntax error
}