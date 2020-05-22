package hw_1;
import java.util.Scanner;

public class Hw_1 {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.print("Enter decimal integer : ");
    int input = scan.nextInt();
    convert(input);
    System.out.println();
    System.out.print("Enter binary integer : ");
    String binInput = scan.next();
    System.out.println(binaryToDecimal(binInput));
  }

  public static void convert(int num) {
    if (num>0) {
      convert(num/2);
      System.out.print(num%2 + " ");
    }
  }

  public static int binaryToDecimal(String binInput){  
    int len = binInput.length();
    if (len == 0) return 0;
    String now = binInput.substring(0,1);
    String later = binInput.substring(1);
    return Integer.parseInt(now) * (int)Math.pow(2, len-1) + binaryToDecimal(later);     
  }
}