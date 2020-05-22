public class Capitalize {
  public static void main (String [] args) throws java.io.IOException {
    String str = "abcdef. ghijk, mlnopqrs. tuv ..................";
    int state = 2;
    for (int i = 0; i < str.length(); ++i) {
      char c = str.charAt(i);
      if (state == 1) {
        System.out.print(c);
        if (c == '.') {
          state = 2;
        }
      } else {
        System.out.print(Character.toUpperCase(c));
        if (c != '.' && c != ' ') {
          state = 1;
        }
      }
    }
  }
}