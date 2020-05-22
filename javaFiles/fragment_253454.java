import java.util.Scanner;
class Xx {
  public static void main(String[] args) {
    int x;
    Scanner Sc = new Scanner(System.in);
    System.out.print("X :  ");
    x = Sc.nextInt();
    for (int y = 0; y <= x; y++) {
      System.out.print("O");
      for (int z = 1; z <= y; z++) {
         if(z==y||y==x)
          System.out.print("O");
         else
        System.out.print("X");

      }
      System.out.println();
    }
  }
}