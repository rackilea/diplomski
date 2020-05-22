private static final String REGEX = "some_regex";
private static final Pattern PATTERN = Pattern.compile(REGEX);

private boolean testRegex(String s) {
    return PATTERN.matcher(s).matches();
}