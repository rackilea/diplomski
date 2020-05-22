String[] words = // split input sentence into words
for(String word: words) {
    if(!wordSet.contains(word)) {
        checkWord(word);
        // do stuff
        wordSet.add(word);
    }
}