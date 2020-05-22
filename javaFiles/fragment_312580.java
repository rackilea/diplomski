String getMostFrequentWord(String input) {
    String[] words = input.split(" ");
    // Create a dictionary using word as key, and frequency as value
    Map<String, Integer> dictionary = new HashMap<String, Integer>();
    for (String word : words) {
        if (dictionary.containsKey(word)) {
            int frequency = dictionary.get(word);
            dictionary.put(word, frequency + 1);
        } else {
            dictionary.put(word, 1);
        }
    }

    int max = 0;
    String mostFrequentWord = "";
    Set<Entry<String, Integer>> set = dictionary.entrySet();
    for (Entry<String, Integer> entry : set) {
        if (entry.getValue() > max) {
            max = entry.getValue();
            mostFrequentWord = entry.getKey();
        }
    }

    return mostFrequentWord;
}