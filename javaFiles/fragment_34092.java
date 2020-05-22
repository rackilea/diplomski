static long method(String word, String[] book) {
  // Construct a trie from all the words in book.
  TrieNode t = new TrieNode();
  for (String b : book) {
    t.add(b, 0);
  }

  // Construct an array to memoize the number of ways to construct
  // prefixes of a given length: result[i] is the number of ways to
  // construct a prefix of length i.
  long[] result = new long[word.length() + 1];

  // There is only 1 way to construct a prefix of length zero.
  result[0] = 1;

  for (int m = 0; m < word.length(); ++m) {
    if (result[m] == 0) {
      // If there are no ways to construct a prefix of this length,
      // then just skip it.
      continue;
    }

    // Walk the trie, taking the branch which matches the character
    // of word at position (n + m).
    TrieNode tt = t;
    for (int n = 0; tt != null && n + m <= word.length(); ++n) {
      if (tt.word) {
        // We have reached the end of a word: we can reach a prefix
        // of length (n + m) from a prefix of length (m).
        // Increment the number of ways to reach (n+m) by the number
        // of ways to reach (m).
        // (Increment, because there may be other ways).
        result[n + m] += result[m];
        if (n + m == word.length()) {
          break;
        } 
      }
      tt = tt.children.get(word.charAt(n + m));
    }
  }

  // The number of ways to reach a prefix of length (word.length())
  // is now stored in the last element of the array.
  return result[word.length()];
}