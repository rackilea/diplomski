private static char[] wordPrefixedAlphabet(String word) {
    Set<Character> letters = new LinkedHashSet<>();
    for (char c : word.toLowerCase().toCharArray())
        if (c >= 'a' && c <= 'z')
            letters.add(c);
    for (char c = 'a'; c <= 'z'; c++)
        letters.add(c);
    char[] alphabet = new char[26];
    int i = 0;
    for (char c : letters)
        alphabet[i++] = c;
    return alphabet;
}