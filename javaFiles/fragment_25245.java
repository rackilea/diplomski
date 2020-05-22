public static String trimTrailingWhitespace(String toTrim) {
    if (toTrim == null) {
        return "";
    }
    int current = toTrim.length() - 1;
    for ( ; current >= 0; current--) {
        char currentChar = toTrim.charAt(current);
        if (!(Character.isWhitespace(currentChar) && !(currentChar == '\n' || currentChar == '\r'))) {
            break;
        }
    }
    return current < 0 ? "" : toTrim.substring(0, current + 1);
}