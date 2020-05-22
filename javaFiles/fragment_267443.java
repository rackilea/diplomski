public List<Word> doInBackground() {
  List<Word> words = new ArrayList<Word>();
  while (!isCancelled()) {
      // do some work, define aNewWord
      words.add(aNewWord);
      publish(new ArrayList<>(words)); // don't publish words directly but create new list
      Thread.pause(someTime);
  }
  return words;
}