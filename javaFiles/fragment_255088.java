/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class StringInABox {
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);

  System.out.println("Enter a phrase or word!");
  String Phrase = scan.nextLine();
  String CapPhrase = Phrase.toUpperCase();
  int PhraseLength = CapPhrase.length();

  for (int Letter = 0; Letter < PhraseLength; Letter++)
   System.out.print(CapPhrase.charAt(Letter) + " ");
  System.out.println();

  for (int Letter = 1; Letter < PhraseLength - 1; Letter++) {
   int IndexFromFront = Letter;
   int IndexFromBack = PhraseLength - 1 - Letter;
   System.out.print(CapPhrase.charAt(IndexFromFront));
   // Print required spaces
   for (int Space = 0; Space < 2 * (PhraseLength - 1) - 1; Space++) {
    System.out.print(" ");
   }
   // End space print
   System.out.print(CapPhrase.charAt(IndexFromBack));
   System.out.println();
  }

  for (int Letter = PhraseLength - 1; Letter >= 0; Letter--)
   System.out.print(CapPhrase.charAt(Letter) + " ");
 }
}