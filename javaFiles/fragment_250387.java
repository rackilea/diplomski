public static boolean[] buildRandomWellFormedWord(int n) {
    boolean[] word = buildRandomBalancedWord(n);
    rearrange(word, 0, word.length);
    return word;
}

public static String toString(boolean[] word) {
    StringBuilder str = new StringBuilder();
    for (boolean b : word)
        str.append(b ? "(" : ")");
    return str.toString();
}