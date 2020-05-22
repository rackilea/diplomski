if (map.containsKey(phNum)) {
    List<String> words = map.get(phNum);
    words.add(strLine);
} else {
    List<String> words = new ArrayList<String>();
    words.add(strLine);
    map.put(phNum, words);
}