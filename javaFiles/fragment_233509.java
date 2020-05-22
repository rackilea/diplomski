public static String encodeNumber(String str) {
    StringBuilder result = new StringBuilder();
    for (int j = 0; j < str.length(); j++) {
        char c = Character.toLowerCase(str.charAt(j));
        if (c < 'a' || c > 'z') {
            result.append(c);
        } else {
            result.append(1 + c - 'a');
        }
    }
    return result.toString();
}