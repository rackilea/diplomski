public static int[] checkLetterInWord(final java.lang.String theWord, final char letter) {
    if (theWord != null) {
        final int returned[] = new int[theWord.length()];
        for (int i = 0; i < theWord.length(); i++) {
            if (theWord.charAt(i) == letter) {
                returned[i] = i;
            } else {
                returned[i] = -1;
            }
        }
        return returned;
    }
    return new int[0];
}