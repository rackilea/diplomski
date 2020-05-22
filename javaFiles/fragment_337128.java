if (word.length() == 3) {
  return word;
} else if (word.length() > 3) {
  return word.substring(word.length() - 3);
} else {
  // whatever is appropriate in this case
  throw new IllegalArgumentException("word has less than 3 characters!");
}