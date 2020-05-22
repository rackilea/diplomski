private String removeTrailingDupes(String s) {
    // Is there a dupe?
    int l = s.length();
    if (l > 1 && s.charAt(l - 1) == s.charAt(l - 2)) {
      // Where to cut.
      int cut = l - 2;
      // What to cut.
      char c = s.charAt(cut);
      while (cut > 0 && s.charAt(cut - 1) == c) {
        // Cut that one too.
        cut -= 1;
      }
      // Cut off the repeats.
      return cut > 0 ? s.substring(0, cut): s;
    }
    // Return it untouched.
    return s;
  }