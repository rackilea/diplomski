/**
 * Matches one or more digits, optionally followed by a . and more digits,
 * followed by whitespace then one or more uppercase letters.
 */
private static final Pattern MONEY_PATTERN =
    Pattern.compile("(\\d+(?:\\.\\d+))\\s+([A-Z]+)");