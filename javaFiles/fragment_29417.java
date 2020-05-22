private static int getIndex(String input, Pattern pattern) {
    Matcher m = pattern.matcher(input);
    if (m.matches()) {
        return Integer.parseInt(m.group(1));
    }
    return -1;
}