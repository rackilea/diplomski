public ArrayList<dictionaryEntry> browse(String s) {
  ArrayList<dictionaryEntry> brow = new ArrayList<dictionaryEntry>();
  for (dictionaryEntry b : hash.values()) {
    if (b.word.startsWith(s)) {
      brow.add(new dictionaryEntry(b.word, b.definition));

    }
  }
  return brow;
}