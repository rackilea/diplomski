public void setDictionary(ArrayList<String> words) {
    dictionary.clear();
    if (words == null) {
        return;//so we can call constructor with null value for dictionary without exception thrown
    }
    dictionary.addAll(words);
}