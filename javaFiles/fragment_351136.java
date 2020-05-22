long uniqueWordCount = Arrays.stream(tokens)
    .map(String::toLowerCase)
    // Build a map from word -> frequency
    .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
    // stream the frequency map entries
    .entrySet().stream()
    // filter to retain unique words (with frequency == 1) 
    .filter(e -> e.getValue() == 1)
    // count them
    .count();