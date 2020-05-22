boolean isPattern(String givenPattern, String stringToMatch) {
    if (givenPattern.empty)
        return stringToMatch.isEmpty();
    char patternCh = givenPatter.charAt(0);
    boolean atEnd = stringToMatch.isEmpty();
    if (patternCh == '*') {
        return isPattenn(givenPattern.substring(1), stringToMatch)
            || (!atEnd && isPattern(givenPattern, stringToMatch.substring(1)));
    } else if (patternCh == '?') {
        return !atEnd && isPattern(givenPattern.substring(1), 
            stringToMatch.substring(1));
    }
    return !atEnd && patternCh == stringToMatch.charAt(0)
          && isPattern(givenPattern.substring(1), stringToNatch.subtring(1);
}