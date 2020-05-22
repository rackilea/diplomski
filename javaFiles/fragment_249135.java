Set<String> stopWords = new HashSet<String>();
stopWords.add("a");
stopWords.add("and");
// and so on ...

String sampleText = "I would like to do a nice novel about nature AND people";
StringBuffer clean = new StringBuffer();
int index = 0;

while (index < sampleText.length) {
  // the only word delimiter supported is space, if you want other
  // delimiters you have to do a series of indexOf calls and see which
  // one gives the smallest index, or use regex
  int nextIndex = sampleText.indexOf(" ", index);
  if (nextIndex == -1) {
    nextIndex = sampleText.length - 1;
  }
  String word = sampleText.substring(index, nextIndex);
  if (!stopWords.contains(word.toLowerCase())) {
    clean.append(word);
    if (nextIndex < sampleText.length) {
      // this adds the word delimiter, e.g. the following space
      clean.append(sampleText.substring(nextIndex, nextIndex + 1)); 
    }
  }
  index = nextIndex + 1;
}

System.out.println("Stop words removed: " + clean.toString());