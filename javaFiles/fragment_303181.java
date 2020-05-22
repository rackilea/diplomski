public static String scramble(String word) {
    if (word.length() < 3) {
        return word;
    }
    String middle = word.substring(1, word.length() - 1);
    return scramble(word.charAt(0), word.charAt(word.length() - 1), middle);
}