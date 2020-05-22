import java.util.ArrayList;
import java.util.Scanner;

 public class StackOverflow {

  public static void main(String[] args) {
     ArrayList<String> inputList = new ArrayList<String>();

     Scanner reader = new Scanner(System.in);
     String input = reader.nextLine();
     inputList.add(input);

     while (!input.equals("null")) {
         input = reader.nextLine();
         inputList.add(input);
     }
  }

 }