private static final String DATE_PATTERN_LETTERS = "uyDMLdgQqYwWEecF";
private static final Pattern DATE_PATTERN_PATTERN = requireAtLeastOne(DATE_PATTERN_LETTERS);
private static final String TIME_PATTERN_LETTERS = "ahKkHmsAN";
private static final Pattern TIME_PATTERN_PATTERN = requireAtLeastOne(TIME_PATTERN_LETTERS);

/**
 * @return a pattern that matches a string that contains
 *          at least one of the letters in {@code requiredLetters} not within single quotes
 */
private static Pattern requireAtLeastOne(String requiredLetters) {
    return Pattern.compile("[^']*(?:'[^']*'[^']*)*[" + requiredLetters + "][^']*(?:'[^']*'[^']*)*");
}

public static boolean validateDatePattern(String template) {
    if (! isValidPattern(template)) {
        return false;
    }
    return DATE_PATTERN_PATTERN.matcher(template).matches();
}

public static boolean validateTimePattern(String template) {
    if (! isValidPattern(template)) {
        return false;
    }
    return TIME_PATTERN_PATTERN.matcher(template).matches();
}

private static boolean isValidPattern(String template) {
    try {
        DateTimeFormatter.ofPattern(template);
        return true;
    } catch (IllegalArgumentException iae) {
        return false;
    }
}