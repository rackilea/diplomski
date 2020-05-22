private static List<String> findClosestMatch(String word) {
    int min = Integer.MAX_VALUE;
    List<String> minWords = new ArrayList<>();
    for (String s : wordContainer) {
        int dist = distance(s, word);
        if (dist < min) {
           min = dist;
           minWords.clear();
        }
        if (dist == min)
           minWords.add(s);
    }
    return minWords;
}