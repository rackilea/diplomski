// code from above here
for (Iterator<Set<String>> iter = anagrams.values().iterator(); iter.hasNext(); ) {
    Set<String> words = iter.next();
    if (words.size() == 1) {
        iter.remove(); // Not anagram: Single spelling only
    } else {
        Set<String> lower = new HashSet<>();
        for (String word : words)
            lower.add(word.toLowerCase());
        if (lower.size() == 1) {
            iter.remove(); // Not anagram: Multiple case variants, but all same spelling
        }
    }
}