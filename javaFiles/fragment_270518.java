public static String hideNonGuesses(String input, Set<Character> guesses) {
    char[] result = new char[input.length()];
    for (int i = 0; i < result.length; i++) {
        char c = input.charAt(i);
        result[i] = guesses.contains(c) ? c : '-';
    }
    return new String(result);
}