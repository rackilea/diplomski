public static int findFirstVowel (String word) {
    int consonant = 0;
    word = word.toUpperCase(); // you need to set word back to the uppercase version

    for (int count = 0; count < word.length(); count++) {
        char letter1 = word.charAt(count);
        String letter2 = (Character.toString(letter1));

        if (isVowel(letter2)) {
            return count;
        }
    }

    return -1;
}