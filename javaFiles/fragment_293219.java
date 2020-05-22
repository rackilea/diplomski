import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DigitsConverter{

    // this will have dictionary relation between digits and words
    private static final Map<Character,String> words = new HashMap<>();

    // can use String array instead of Map as suggested in comments
    private static final String[] alsoWords =  {"zero","one","two", "three", "four", "five", "six", "seven", "eight", "nine"}

    // provide mapping of digits to words
    static {

        words.put('0', "zero");
        words.put('1', "one");
        words.put('2', "two");
        words.put('3', "three");
        words.put('4', "four");
        words.put('5', "five");
        words.put('6', "six");
        words.put('7', "seven");
        words.put('8', "eight");
        words.put('9', "nine");
    }


       public static void main(String args[]) throws FileNotFoundException {

           Scanner scanner = new Scanner(new File("../SomeFile"));

           while (scanner.hasNextInt()) {

               char[] chars = ("" + scanner.nextInt()).toCharArray();

               System.out.print(String.valueOf(chars) +": ");

               // for each digit in a given number
               for (char digit: chars) {

                  // print word for that digit
                  System.out.print(words.get(digit) + " ");

                  // if String array is used instead of Map
                  System.out.print(alsoWords[((int)digit- 48)] + " ");

               }
               System.out.println();
           }

           scanner.close();

       }
    }