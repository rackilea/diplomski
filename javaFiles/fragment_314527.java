private String replaceStringFromPatternSearch2(String stringToSearch, String patternString, String replacementString) {
    String replacedString = "";
    Pattern stringPattern = Pattern.compile(patternString);
    int startSearch = 0;
    Matcher stringMatcher = stringPattern.matcher(stringToSearch);
    while (stringMatcher.find(startSearch)) {
        int start = stringMatcher.start(1);
        int end = stringMatcher.end(1);
        replacedString += stringToSearch.substring(startSearch, start) + replacementString + stringToSearch.substring(end);
        startSearch = end + 1;
    }
    if (!replacedString.isEmpty()) {
        return replacedString;
    } else {
        return stringToSearch;
    }
}

private String replaceStringFromPatternSearch(String stringToSearch, String patternString, String replacementString) {
    String replacedString = "";
    Pattern stringPattern = Pattern.compile(patternString);
    int startSearch = 0;
    Matcher stringMatcher = stringPattern.matcher(stringToSearch);
    StringBuffer sb = new StringBuffer();
    while (stringMatcher.find()) {
        String wholeGroup = stringMatcher.group(0);
        replacedString = wholeGroup.replace(stringMatcher.group(1), replacementString);
        stringMatcher.appendReplacement(sb, replacedString);
    }
    stringMatcher.appendTail(sb);
    if (sb.length() > 0) {
        return sb.toString();
    } else {
        return stringToSearch;
    }
}