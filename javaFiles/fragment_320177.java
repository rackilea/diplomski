import java.util.*;
import java.util.regex.Pattern;

public class listMnemonics

{

   public static void main(String[] args)

{

   // Defines the "keypad" similar to that of a phone
   char[][] letters = 

   {{'0'},{'1'},{'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'}, 
   {'M','N','O'},{'P','Q','R','S'},{'T','U','V'},{'W','X','Y','Z'}};

      // Creates the Scanner
      Scanner scan = new Scanner(System.in);

      // Gives instructions to the user to enter 3-digit number
      // This 'Pattern' also guarantees that only 3 digits works.

      Pattern threeDigitNumber = Pattern.compile("[0-9]{3}");

      int j;

      do

      {

         System.out.println("Please enter a 3-digit phone number: ");

         // If it's not a 3-digit int, try again
         while (!scan.hasNext(threeDigitNumber)) 

            {

            System.out.println("That's not a 3-digit number! Try again!");

            // This is important!
            scan.next(); 

            }

         j = scan.nextInt();

      }

      while (j <= 0);

      String n = Integer.toString(j);


      // Determines char length based on user input
      char[][] sel = new char[n.length()][];

      for (int i = 0; i < n.length(); i++)

      {

         // Grabs the characters at their given position
         int digit = Integer.parseInt("" +n.charAt(i));
         sel[i] = letters[digit];

      }

   mnemonics(sel, 0, "");

}

// Here is where the magic happens and creates the possible
// letter combinations based on the user input and characters
// selected in previous steps.
public static void mnemonics(char[][] symbols, int n,  String s) 

{

   if (n == symbols.length)

   {

      System.out.println(s);
      return;

   }

   for (int i = 0; i < symbols[n].length; i ++) 

   {

      mnemonics(symbols, n+1, s + symbols[n][i]);

   }
 }
}