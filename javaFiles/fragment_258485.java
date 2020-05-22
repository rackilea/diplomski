private static List<String> WORDS;

private static List<String> getWords() throws IOException {
  if (WORDS == null) {
    List<String> words = new LinkedList<String>();
    String line;
    BufferedReader br = new BufferedReader(new FileReader("my_dictionary.txt"));
    while ((line = br.readLine()) != null) {
      words.add(line);
    }
    WORDS = ImmutableList.copyOf(words);
  }
  return WORDS;
}