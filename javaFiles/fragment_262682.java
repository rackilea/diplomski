Set<String> words = lengthToWords.get(word.length());
if(words == null) {
  words = new TreeSet<String>();
  lengthToWords.put(word.length(), words);
} 
words.add(word);