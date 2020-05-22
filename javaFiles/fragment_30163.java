public static boolean checkPatternMatching(String sourceToScan, String searchPattern) {
    boolean patternFounded;

    if (sourceToScan == null) {
       patternFounded = false;
    } else {
       Pattern pattern = Pattern.compile(searchPattern, Pattern.CASE_INSENSITIVE);
       Matcher matcher = pattern.matcher(sourceToScan);
       patternFounded = matcher.matches();
    }
    return patternFounded;
}