import java.util.Scanner;
public class HailStoneSequence {
  static Scanner MyScanner = new Scanner(System.in);
  public static void main(String[] args) {
    int num = 1;
    while(num != 0) {
       System.out.println("Enter a number to generate the Hailstone Sequence for that number. ");
       num = MyScanner.nextInt(); //Taking input from user
       while (num>1)
       {
          if (num%2 == 0)
          {
             num /= 2; 
             System.out.print(num+"  ");
          }
          else
          {
             num = (num*3)+ 1; 
             System.out.print(num+"  ");
          }
       }
    }
  }

}