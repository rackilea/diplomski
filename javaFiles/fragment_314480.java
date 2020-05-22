private static String piggyWord(String word) {
        int split = firstVowel(word);
        if(beginsWithVowel(word)) {
            return word.substring(split + 1) + word.substring(0, split + 1); //Since vowel is in 1st place, substring(0,0) returns empty string.
        } else {
        return word.substring(split) + word.substring(0, split)+"ae";
        }
}