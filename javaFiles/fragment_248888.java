import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

 public static final String EXIT_COMMAND = "exit";

 public static void main(final String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  System.out.println("Enter some text, or '" + EXIT_COMMAND + "' to quit");

  while (true) {

   System.out.print("> ");
   String input = br.readLine();

   // Creating array of string length 
   char[] ch = new char[input.length()];

   // Copy character by character into array 
   for (int i = 0; i < input.length(); i++) {
    ch[i] = input.charAt(i);
   }
   //looking for the "h" char
   for (int i = 0; i < ch.length; i++) {
    if ('h' == ch[i]) {
     System.out.println("*** Found....");
    } else {
     System.out.println("Not Found....");
    }
   }


   if (input.length() == EXIT_COMMAND.length() && input.toLowerCase().equals(EXIT_COMMAND)) {
    System.out.println("Exiting.");
    return;
   }

  }
 }
}