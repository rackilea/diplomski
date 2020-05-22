public static String find(String input, int colonCount) {
    int lastIndex = input.length();
    while (colonCount > 0) {
        lastIndex = input.lastIndexOf(':', lastIndex-1);
        colonCount--;
    }
    return lastIndex >= 0 ? input.substring(0, lastIndex) : null;
}