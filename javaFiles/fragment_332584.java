//GETTING SIMILAR WORD ARRAYLIST
public ArrayList<ArrayList<String>> getSimilarWords(String searchWord) {
    this.searchWord = searchWord;
    char[] wordAsCharacterArray = searchWord.toCharArray(); //Convert search String to a character array

    //Clear the list before adding words
    similarWordArrayList.clear();

    //Call helper methods to add the suggested similar words to the similarWordArrayList
    similarWordArrayList.add(charSwap(wordAsCharacterArray));   //Add swapped character suggestions
    similarWordArrayList.add(charRemove(wordAsCharacterArray)); //Add removed character suggestions
    similarWordArrayList.add(charAdd(wordAsCharacterArray)); //Add removed character suggestions
    similarWordArrayList.add(charReplace(wordAsCharacterArray)); //Add removed character suggestions

    return similarWordArrayList;
}