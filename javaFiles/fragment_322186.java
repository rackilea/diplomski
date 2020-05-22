public static java.util.List<Integer> checkLetterInWord(final java.lang.String theWord, final char letter) {
    final java.util.List<Integer> returned = new java.util.ArrayList<Integer>();
    if (theWord != null) {
        for (int i = 0; i < theWord.length(); i++) {
            if (theWord.charAt(i) == letter) {
                returned.add(Integer.valueOf(i));
            }
        }
    }
    return returned;
}