while (word.compareToIgnoreCase(k) != 0) {

  words[i] = word;
  i = i + 1;
  word = sc.next();
}
words[i] = word; // Add the last item entered