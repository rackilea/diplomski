String ResultString = null;
Pattern regex = Pattern.compile("\\b[0-9A-Fa-f]+_16\\b");
Matcher regexMatcher = regex.matcher(subjectString);
if (regexMatcher.find()) {
    ResultString = regexMatcher.group();
}