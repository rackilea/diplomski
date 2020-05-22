private Map<Integer, Integer> extractNumbers(Map<Integer, Integer> intOccurences,
       int minTotal, int maxTotal) {
    Map<Integer, Integer> result = new HashMap<>();
    for (Map.Entry<Integer, Integer> entry : intOccurences.entrySet()) {
        int total = entry.getValue();
        if (total >= minTotal && total <= maxTotal) {
            result.put(entry.getKey(), total);
        }
    }
    // not sure if you want to remove the ones from the original map
    return result;
}