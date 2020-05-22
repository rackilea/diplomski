static final Pattern INVALID_CHARS = Pattern.compile("[/'()&<>^~`|\"]");

boolean isInvalid(String s) {
    if (s.indexOf("javascript") != -1) {
        return true;
    }
    if (s.indexOf("script") != -1) {
        return true;
    }
    if (INVALID_CHARS.matcher(s).find()) {
        return true;
    }
    return false;
}