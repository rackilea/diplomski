Collection<LinkedList<String>> groupAnagrams(List<String> words) {
    Map<String, LinkedList<String>> anagramMap = new HashMap<>();
    for(String word : words) {
        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        String sortedKey = new String(wordChars);
        LinkedList<String> anagramList = anagramMap.get(sortedKey);
        if(anagramList == null) {
            anagramMap.put(sortedKey, anagramList = new LinkedList<>());
        }
        anagramList.add(word);
    }
    return anagramMap.values();
}