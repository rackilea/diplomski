Map<Character, Long> frequencies = new HashMap<>();
for (int i = 0; i < s.length(); ++i) {
    char c = s.charAt(i);
    if (frequencies.containsKey(c)) {
        frequencies.put(c, frequencies.get(c) + 1L);
    } else {
        frequencies.put(c, 1L);
    }
}

TreeMap<Long, Long> frequencyCounts = new TreeMap<>();
for (Long freq : frequencies.values()) {
    if (frequencyCounts.containsKey(freq)) {
        frequencyCounts.put(freq, frequencyCounts.get(freq) + 1L);
    } else {
        frequencyCounts.put(freq, 1L);
    }
}