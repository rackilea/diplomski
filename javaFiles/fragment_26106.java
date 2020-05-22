val getIndicesOfAllWords: MutableList<Triple<String, Int, Int>> = mutableListOf()

for (word in 0 until wordList.count()){
    if (getIndicesOfAllWords.count()==0) {
        val firstIndex = desc!!.indexOf(wordList[word])
        val matchLength = wordList[word].length
        getIndicesOfAllWords.add(Triple(wordList[word], firstIndex, matchLength))
    } else{
        val firstIndex = desc!!.indexOf(wordList[word], getIndicesOfAllWords[word-1].second+1)
        val matchLength = wordList[word].length
        getIndicesOfAllWords.add(Triple(wordList[word], firstIndex, matchLength))
    }
}