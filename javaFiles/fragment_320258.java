public String[] getData() {
  String[] arr = new String[wordListA.size()];

  // ****** don't create a new object -- use the one we have ***
  //  wordPair = new WordPair();  ****** don't create a new one!

  String[] temp2 = wordPair.remove(wordListA.toArray(arr));

  // use the collection class method to turn this into a
  // primitive array
  return temp2;
}