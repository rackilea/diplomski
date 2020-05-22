import java.util.Scanner;   
public class StringShiftTwoLeftThenRight
{
    public static void main(String[] args)
    {
        String word, rightShift = "", leftShift = "";

        Scanner keyboard = new Scanner(System.in);
            System.out.print("\nEnter a word: ");
            word = keyboard.nextLine();
            rightShift = (word.substring((0),
            (word.length()-2)));

            leftShift = (word.substring((2),(word.length())));

            System.out.println("\nThe String shifted two to right looks like this: " + rightShift);
            System.out.println("\nThe String shifted two to left looks like this: " + leftShift);
            System.out.println("\nThe String as it is looks like: " + word);
    }
}