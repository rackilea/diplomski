private static int searchCharacter(String string, char ch) {
    final int chASCII = (int) ch;
    return seachCharacter(string, chASCII);
}

private static int seachCharacter(String string, int chASCII) {
    if (string == null || string.isEmpty()) {
        return -1;
    }
    for (int i = 0; i < string.length(); i++) {
        char c = string.charAt(i);
        int cASCII = (int) c;
        if (chASCII == cASCII) {
            return i; // found at index i
        }
    }
    return -1;
}