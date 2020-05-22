HashMap<String, Integer> occurenceMap = new HashMap<>();

    for (String word : document) {
        Integer wordOccurences = occurenceMap.get(word);
        if (wordOccurences == null) {
            wordOccurences = Integer.valueOf(1);
        } else {
            wordOccurences += 1;
        }
        occurenceMap.put(word, wordOccurences);
    }