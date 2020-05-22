Map<String, Set<String>> anagrams = new HashMap<>();
for (String word : input.replaceAll("[^äÄöÖüÜßa-zA-Z ]", "").split(" ")) {
    char[] letters = word.toLowerCase().toCharArray();
    Arrays.sort(letters);
    String key = new String(letters);
    anagrams.computeIfAbsent(key, k -> new TreeSet<>(String.CASE_INSENSITIVE_ORDER))
            .add(word);
}
anagrams.values().removeIf(words -> words.size() == 1);