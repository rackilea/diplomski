Map<String, Set<String>> soundexToWords = ...
for (String word : words) {
    String sdex = soundex(word);
    Set<String> similarWords = soundexToWords.get(sdex));
    if (similarWords == null) {
        similarWords = new HashSet<>();
        soundexToWords.put(sdex, similarWords);
    }
    similarWords.add(word);
}

Set<String> similarWords(String word) {
    return soundexToWords.get(soundex(word));
}