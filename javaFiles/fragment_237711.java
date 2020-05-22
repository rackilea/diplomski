private static int countOf(String in, char ch) {
    int count = 0;
    for (char c : in.toCharArray()) {
        if (c == ch) {
            count++;
        }
    }
    return count;
}