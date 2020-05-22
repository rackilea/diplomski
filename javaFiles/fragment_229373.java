public static String urlTokenEncode(String inputString) {
    if (inputString == null) {
        return null;
    }
    if (inputString.length() < 1) {
        return null;
    }

    // Step 1: Do a Base64 encoding
    String base64Str = new String(java.util.Base64.getEncoder().encode(inputString.getBytes()));

    // Step 2: Transform the "+" to "-", and "/" to "_"
    base64Str = base64Str.replace('+', '-').replace('/', '_');

    // Step 3: Find how many padding chars are present at the end
    int endPos = base64Str.lastIndexOf('=');
    char paddingChars = (char)((int)'0' + base64Str.length() - endPos);

    // Step 4: Replace padding chars with count of padding chars
    char[] base64StrChars = base64Str.toCharArray();
    base64StrChars[endPos] = paddingChars;

    return new String(base64StrChars);
}