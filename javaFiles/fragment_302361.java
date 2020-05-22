import java.util.Scanner;

public class WordPlayTester {

  public static void main(String [] args) {

    String word;
    int key= 0;

    Scanner in = new Scanner(System.in);
    System.out.println("-Type any word-");
    word = in.nextLine();

    System.out.println("Insert a Key number");
    int select = in.nextInt();

    for (int i=0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c >= 'A' && c <= 'Z') {
        c = (char)(c - (int)'A');
        int n = c+select;
        n = n % 26;
        if (n < 0) {
          n = n + 26;
        }
        c = (char)(n + (int)'A');
      }
      System.out.print(c);
    }
    System.out.print('\n');
  }
}