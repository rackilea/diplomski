while(all documents are not read) {
    char[][] wordsInDoc = new char[numOfWords][];
    for(int i=0; i < numWordsInDoc; i++) {
        wordsInDoc[i] = getNextWord();
    }
    processWords(wordsInDoc);
}