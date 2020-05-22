private static String urlEncodeLowerCase(String stringInput) {
    Pattern pattern = Pattern.compile("%[0-9]{1}[A-Z]{1}");
    Matcher matcher = pattern.matcher(stringInput);
    while (matcher.find()) {
        String s = matcher.group();
        stringInput = stringInput.replace(s, s.toLowerCase());
    }
    return stringInput;
}