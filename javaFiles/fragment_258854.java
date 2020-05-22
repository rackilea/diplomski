private static char[] wordPrefixedAlphabet(String word) {
    boolean[] used = new boolean[26];
    char[] alphabet = new char[26];
    int i = 0;
    for (char c : word.toLowerCase().toCharArray())
        if (c >= 'a' && c <= 'z' && ! used[c - 'a']) {
            used[c - 'a'] = true;
            alphabet[i++] = c;
        }
    for (char c = 'a'; c <= 'z'; c++)
        if (! used[c - 'a'])
            alphabet[i++] = c;
    return alphabet;
}