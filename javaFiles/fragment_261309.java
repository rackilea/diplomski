public static void findChar(char character, String words[]) {
    //ArrayList for putting the matched words
    ArrayList<String> wordsContainingCharacter = new ArrayList<String>();
    for (String word : words) {
        // Check if it contains the character
        if (word.contains(Character.toString(character))) {
            wordsContainingCharacter.add(word);
        }

    }
    //2.check is to be put after the loop
    if (wordsContainingCharacter.size() > 0) {
        System.out.println("Words containing the letter " + character
                + " : " + wordsContainingCharacter);
    } else {
        System.out.println("Character is not in any word");
    }
}