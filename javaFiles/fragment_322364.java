public static boolean isReverse(String word1, String word2) {
    if (word1 == null || word2 == null) {
        return false;
    }
    if (word1.length() == 1 && word2.length() == 1) {
        //Used equals just for fast compare
        return word1.equals(word2);
    } else if (word1.length() == word2.length()) {
        if (word1.charAt(0) == word2.charAt(word2.length() - 1)) {
            String firstWord = word1.substring(1, word1.length());
            String secondWord = word2.substring(0, word2.length() - 1);
            System.out.printf("Trimmed %s, %s to %s, %s\n", word1, word2, firstWord, secondWord);
            return isReverse(firstWord, secondWord);
        } else {
            //Characters didn't matched
            return false;
        }
    } else {
        //Lenght doesn't match
        return false;
    }
}