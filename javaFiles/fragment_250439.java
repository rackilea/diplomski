private static int recur(char character, String text, int index) {
    if (index >= text.length()) {
        return 0;
    }

    int count = text.charAt(index) == character? 1 : 0;
    return count + recur(text, character, index + 1);
}