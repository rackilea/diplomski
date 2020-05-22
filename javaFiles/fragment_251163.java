// Looping over string characters
private static String convert(String input) {
    StringBuilder buf = new StringBuilder(input.length() + 16);
    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
            buf.append(c);
        else
            buf.append(String.format(":%04X", (int) c));
    }
    return buf.toString();
}