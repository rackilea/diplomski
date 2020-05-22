public class Test {
  public void test() {
    System.out.println(removeTrailingDupes("abcdaaaaefghaaaaaaaaa"));
    System.out.println(removeTrailingDupes("012003400000000"));
    System.out.println(removeTrailingDupes("0120034000000001"));
    System.out.println(removeTrailingDupes("cc"));
    System.out.println(removeTrailingDupes("c"));
  }

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
      return s.substring(0, cut);
    }
    // Return it untouched.
    return s;
  }

  public static void main(String args[]) {
    new Test().test();
  }
}