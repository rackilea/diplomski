import java.util.Scanner;
class main { //Main
 public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int firstnumber = 0;
  int secondnumber = 0;
  char operator;

  boolean erase = true;



  while (erase) { //While Loop (main)
   System.out.println("Enter First Number");
   firstnumber = scan.nextInt();



   System.out.println("Enter Second Number");
   secondnumber = scan.nextInt();

   System.out.println("Select Operator.");
   operator = scan.next().charAt(0);
   System.out.println("For Multiplaction: Type X");
   System.out.println("For Division: Type %");
   System.out.println("For Addition: Type +");
   System.out.println("For Subtraction: Type -");

  } //While Loop (main)
 }
} //Main