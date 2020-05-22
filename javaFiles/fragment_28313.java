public class Words implements Iterator<String> {
  private final Iterator<HasWord> sentences;
  private Iterator<String> currentSentence;

  public boolean hasNext() {
    return currentSentence.hasNext() || sentences.hasNext();
  }

  public String next() {
    if (currentSentence.hasNext()) {
      return currentSentence.next();
    }
    currentSentence = sentences.next();
    return next(); // will return the first word of the next sentence
  }
  //remove() omitted for brevity
}