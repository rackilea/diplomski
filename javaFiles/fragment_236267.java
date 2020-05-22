ArrayList<String> words = new ArrayList<String>();

words.add("zebra");
words.add("buzzer");
words.add("zappaz");

for (String word : words) {
  // calculate the length difference
  if (word.length() - word.replace("z", "").length() > 1) {
    System.out.println(word);
  }
}