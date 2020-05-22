// Using regular expression
private static String convert(String input) {
    StringBuffer buf = new StringBuffer(input.length() + 16);
    Matcher m = Pattern.compile("[^a-zA-Z0-9]").matcher(input);
    while (m.find())
        m.appendReplacement(buf, String.format(":%04X", (int) m.group().charAt(0)));
    return m.appendTail(buf).toString();
}