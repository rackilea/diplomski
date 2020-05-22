private static List<List<String>> getSubSet(List<String> set, String word){
    List<List<String>> phrases = new ArrayList<>();
    int indexOfWord = set.indexOf(word);
    int len = 1;
    while(indexOfWord-len>=0 || indexOfWord+len<=set.size()){
        if (indexOfWord-len>=0)
            phrases.add(set.subList(indexOfWord-len, indexOfWord+1));
        if (indexOfWord+len<set.size())
            phrases.add(set.subList(indexOfWord, indexOfWord+len+1));
        len++;
        if(len>4) break;
    }
    return phrases;
}