Map<String, Integer> wordsFreq1 = ... // read from file
    Map<String, Integer> wordsFreq2 = ... // read from file

    Set<String> commonWords = new HashSet<>(wordsFreq1.keySet());
    commonWords.retainAll(wordsFreq2.keySet());

    // Map that contains the summarized frequencies of all words
    Map<String, Integer> allWordsTotalFreq = new HashMap<>(wordsFreq1);
    wordsFreq2.forEach((word, freq) -> allWordsTotalFreq.merge(word, freq, Integer::sum));

    // Map that contains the summarized frequencies of words in common
    Map<String, Integer> commonWordsTotalFreq = new HashMap<>(allWordsTotalFreq);
    commonWordsTotalFreq.keySet().retainAll(commonWords);

    // List of common words sorted by frequency:
    List<String> list = new ArrayList<>(commonWords);
    Collections.sort(list, Comparator.comparingInt(commonWordsTotalFreq::get).reversed());