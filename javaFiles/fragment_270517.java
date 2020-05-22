public static String hideNonGuesses(String input, Set<Character> guesses) {
    char[] result = input.toCharArray();
    for (int i = 0; i < result.length; i++) {
        if (!guesses.contains(result[i])) {
            result[i] = '-';
        }
    }
    return new String(result);
}