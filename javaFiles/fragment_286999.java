package minmax;

import java.util.Scanner;

public class MinMax {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Combien de notes vous avez? ");
    int x = in.nextInt();

    double a = 0;

    for (int y = 0; y < x; y++) {
      int z;
      do {
        System.out.println("Mettez votre note :");
        z = in.nextInt();
      }
      while (z < 0 || z > 20);
      a = a + z;
    }

    System.out.println("Votre moyenne est : " + (a / x));
  }
}