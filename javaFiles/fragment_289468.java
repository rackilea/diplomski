public class JammedWords {
  public static int ways(String sentence, String[] words) {
    if (sentence.isEmpty()) {
      // The trivial case: the sentence is empty. Return a single number.
    } else {
      int c = 0;
      for (String w: words) {
        if (sentence.startsWith(w)) {
          // call method recursively, update counter `c`.
        }
      }
      return c;
    }
  }
  public static void main(String[] args) {
    System.out.println(ways("ookookook", new String[]{"ook", "ookook"}));
    System.out.println(ways("oogamookoogumook", new String[]{"ooga","oogam","oogum","mook","ook"}));
  }
}