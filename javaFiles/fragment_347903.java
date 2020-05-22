static boolean equals(String word1, String word2, int mistakesAllowed) {
    if(word1.equals(word2)) // if word1 equals word2, we can always return true
        return true;

    if(word1.length() == word2.length()) { // if word1 is as long as word 2
        for(int i = 0; i < word1.length(); i++) { // go from first to last character index the words
            if(word1.charAt(i) != word2.charAt(i)) { // if this character from word 1 does not equal the character from word 2
                mistakesAllowed--; // reduce one mistake allowed
                if(mistakesAllowed < 0) { // and if you have more mistakes than allowed
                    return false; // return false
                }
            }
        }
    }

    return true;
}