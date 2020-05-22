String findTheMostOccuredLetter(String S) {
    // Comment 1: initialize array
    int[] occurrences = new int[26];
    for (char ch : S.toCharArray()) {
        occurrences[ch - 'a']++;
    }

    char best_char = 'a';
    int  best_res  = 0;

    // Comment 2: the array is searched in reverse order
    // for (int i = 1; i < 26; i++) { // it is your code
    for (int i = occurrences.length - 1; i >= 0 ; i--) {
        if (occurrences[i] >= best_res) {
            best_char = (char)((int)'a' + i);
            best_res  = occurrences[i];
        }
    }

    return Character.toString(best_char);
}