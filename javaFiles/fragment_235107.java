import java.util.Scanner;

public class LengthOfName {
    public static void main(String[] args) {
         Scanner reader = new Scanner(System.in);
         System.out.println("Type your name: ");
         String input = reader.nextLine();


   calculateCharecters(input);

}
public static int calculateCharecters(String text){

    int texts = input.length();
    System.out.println("Number of charecters: " + texts);
    return texts;
}
}