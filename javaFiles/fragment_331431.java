import java.util.Scanner;
class Power
{
   public static void main(String[] args)
   {
      Double x;
      Scanner input = new Scanner(System.in);
      System.out.println("What is the maximum power of 0.1?");
      x = input.nextDouble(); //Use nextDouble to take in double
      Double n = 0.1;
      int exp = 1;
      Double Answer = 0.0; //You have to declare Answer outside of the while loop below or else Answer will be undefined when you try to print it out in the last line.
      while (exp <= x)
      {
         Answer = Math.pow(n, exp);
         exp++;
      }
      System.out.print(Answer);
   }
}