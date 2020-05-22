List<Map<String,Integer>> wordsPerChunck = new ArrayList<>();

while (word.size() - chunkStartIndex > 0) {

    // Initialize a chunck-specific word counter
    Map<String, Integer> countInChunck = new HashMap<>();
    wordsPerChunck.add(countInChunck);
    ...
    for (int i = 0; i < chunkOfWords.size(); i++) {

        String word1 = chunkOfWords.get(i);

        if (word1.matches("[A-Z][a-z][a-z]\\w+")) {

            wordsInTheMiddle.putIfAbsent(word1, 0);
            wordsInTheMiddle.put(word1, oldCount + 1);
            countInChunck.putIfAbsent(word1, 0);
            // Increase the count in this chunck
            countInChunck.put(word1, countInChunck.get(word1) + 1);

        }
    }