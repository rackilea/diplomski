String[] msgWords = message.split("\\b");
for (String word : msgWords) {
  if (aswear.contains(word.toLowerCase(Locale.US))) {
    // do whatever has to be done
    break;
  }
}