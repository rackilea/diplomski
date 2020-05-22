public static Map<String, Integer> countOldschool(String input) {
    Map<String, Integer> wordcount = new HashMap<>();
    Matcher matcher = Pattern.compile("\\w+").matcher(input);
    while (matcher.find()) {
        String word = matcher.group().toLowerCase();
        wordcount.put(word, wordcount.getOrDefault(word, 0) + 1);
    }
    return wordcount;
}