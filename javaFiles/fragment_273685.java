public static boolean noVowel(String word) {
        for(int i = 0; i < word.length(); i++) {
           //if a vowel found then return false
           if (word.charAt(i) == 'a') {
              return false;
           }
           if (word.charAt(i) == 'e') {
              return false;
           }
           if (word.charAt(i) == 'i') {
              return false;
           }
           if (word.charAt(i) == 'o') {
              return false;
           }
           if (word.charAt(i) == 'u') {
              return false;
           }
           if (word.charAt(i) == 'y') {
              return false;
           }

       }
    return true; // No vowel found, return true
}