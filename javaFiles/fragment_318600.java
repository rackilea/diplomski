HashSet<String> uniqueWords = new HashSet<>();

for (String line : lines) {
  String[] words = line.split(" ");

  for (String word : words) {
    uniqueWords.add(word);
  }
}