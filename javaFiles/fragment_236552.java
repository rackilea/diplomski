public IPManager(String dictionaryType, int initialSize){
    if(st1.equals(dictionaryType))
        ipD = new LinkedListDictionary();
    else if(st2.equals(dictionaryType))
        ipD = new HashDictionary(initialSize);
    else if(st3.equals(dictionaryType))
        ipD = new ArrayDictionary(initialSize);
    else
        throw new UnsupportedOperationException();
}