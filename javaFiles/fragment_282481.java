public static void main(final String[] args) {
  final StringTokenizer tokenizer = new StringTokenizer(paragraph.replace(".", " ").toLowerCase());
  final StringBuilder phrase = new StringBuilder();
  final Set<String> numberSet = NUMBER_MAP.keySet();

  while (tokenizer.hasMoreTokens()) {
    final String token = tokenizer.nextToken();

    if (numberSet.contains(token)) {
      if (phrase.length() > 0) {
        phrase.append(" ");
      }
      phrase.append(token);
    } else if (!IGNORED_WORDS.contains(token)) {
      processPhrase(phrase.toString());
      phrase.setLength(0);
    }
  }

  processPhrase(phrase.toString());
}