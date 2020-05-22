Set<String> getCartesianProduct(List<String> originalWords, TreeMap<String, Set<String>> wordVariationSet) {
    Set<String> resultSet =new HashSet<String>(); // to store answer
    varyWord(resultSet, "", originalWords, wordVariationSet, 0);  // begin recursion with empty sentence
    return resultSet;  // return result
}

void varyWord(Set<String> result, String sentence, List<String> originalWords, Map<String, Set<String>> wordVariationSet, int index) {
    if (index==originalWords.size()) {  // no more words to vary -> sentence is complete
        result.add(sentence);  // add to results
        return;  // done (return from recursion)
    }
    if (index>0) sentence += " ";  // add a space if working on any but first word
    String theOriginalWord = originalWords.get(index);  // grab original word
    varyWord(result, sentence + theOriginalWord, originalWords, wordVariationSet, index+1);  // add to sentence and vary next word
    Set<String> wordVariations = wordVariationSet.get(theOriginalWord);  // grab variations of this word
    if (wordVariations!=null)  // make sure they're not null
        for(String word: wordVariations)  // iterate over variations
            varyWord(result, sentence + word, originalWords, wordVariationSet, index+1);  // add to sentence and vary next word
}