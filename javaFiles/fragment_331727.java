import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyFirstProject {

  public static void main(String argv[]) throws IOException {

    //This line will create a buffered reader that reads from the system input using an input stream reader
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //input will contain the first line of input from the user   
    /**
     * This asks a question.
     */
    System.out.println("What is your input?");
    String input = bufferedReader.readLine();
    /**
     * This returns a valediction or the input.
     */
    if (input.equals("exit")) {
        System.out.println("GOODBYE!");
    }
    else {
        //****** HERE'S IS CHANGE! ********
        System.out.println(numberOfWords(input));
    }


    }


/**
 * This counts the number of words (including spaces) in a string.
 * @param words The user input.
 * @return The number of words in a string.
 */
public static String numberOfWords(String words) {
  int count = 0;
  if (words.length() == 1) {
      count++;
      return (String.valueOf(count) + "word");
  }
  if (words.length() > 1) {
      for (int i = 0; i <= words.length(); i++) {
          if (words.charAt(i) == ' ') {
              count++;
          }
      }
      return (String.valueOf(count) + "words");
  }
  else {
      return (String.valueOf(count) + "words");
  }
}
}