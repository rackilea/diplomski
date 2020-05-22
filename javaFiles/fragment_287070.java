public class Capitalize {
  public static void main (String [] args) throws java.io.IOException {
    int state = 2;
    int c = System.in.read();
    while (c != -1) {
      if (state == 1) {
        System.out.print((char)c);
        if (c == '.') {
          state = 2;
        }
      } else {
        System.out.print(Character.toUpperCase((char)c));
        if (c != '.' && c != ' ') {
          state = 1;
        }
      }
      c = System.in.read();
    }
  }
}