import java.util.Scanner;
public class Capitalize {
  public static void main (String [] args) {
    Capitalize instance = new Capitalize();
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        instance.capitalize_and_print(s.nextLine());
      }
    }
  }

  public void capitalize_and_print (String s) {
    int state = 0;
    for (int i = 0; i < s.length(); ++i) {
      switch (state) {
        case 0:
          System.out.print(s.charAt(i));
          if (s.charAt(i) == '.') {
            state = 1;
          }
          break;
        case 1:
          System.out.print(Character.toUpperCase(s.charAt(i)));
          if (s.charAt(i) != '.' && s.charAt(i) != ' ') {
            state = 0;
          }
          break;
      }
    }
  }
}