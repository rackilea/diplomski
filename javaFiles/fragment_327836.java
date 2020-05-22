boolean wordTyped(String typedWord) {

    if (typedWord.isEmpty()) {
        return false;
    }
    //System.out.println("Typed word: " + typedWord);

    boolean suggestionAdded = false;

    for (String word : dictionary) {//get words in the dictionary which we added
        boolean fullymatches = true;
        for (int i = 0; i < typedWord.length(); i++) {//each string in the word
            if (!typedWord.toLowerCase().startsWith(String.valueOf(word.toLowerCase().charAt(i)), i)) {//check for match
                fullymatches = false;
                break;
            }
        }
        if (fullymatches) {
            addWordToSuggestions(word);
            suggestionAdded = true;
        }
    }
    return suggestionAdded;
}