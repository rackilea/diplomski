import java.util.*;
import java.io.*;
public class WordLink
{
   public static void main(String[] args)throws Exception
   {

  Scanner keyboard = new Scanner(System.in);
  System.out.println("WordLink");
  System.out.println();

  System.out.println("A. set the difficult level");
  System.out.println("B. display the dictionary");
  System.out.println("C. insert a word to the disctionary");
  System.out.println("D. play the game");
  System.out.println("E. exit");
  System.out.println();

  System.out.print("Select a function from the menu: ");
  char choice = keyboard.next().charAt(0);

  switch(choice)
  {
     case 'A':
        System.out.println("Option 1");
       String content = Read();
       //use it 
        break;
     case 'B':
        System.out.println("Option 2");
        break;
     case 'C':
        System.out.println("Option 3");
        break;
     default:
        System.out.println("Invailid");
        break;
  }
}// main() closed here


  public static String Read() throws IOException//removed void 
  {

    String content = "";
     File text = new File ("dictionary.txt");

     BufferedReader br = new BufferedReader(new FileReader(text));
     // your need to read file here and save into content to use it later

     System.out.println("Set the difficulty level");

     return content;//return a String
  }

   //}// removed this

}// extra character removed here