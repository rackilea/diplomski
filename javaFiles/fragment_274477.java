import java.util.Scanner; 
public class DigitSumming {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println ("Please enter a sentence: ");
        /* Corrected Here */
        String userSentence = in.nextLine();

        //writing for loop to check each character
        int sum = 0, i;
        for (i = 0; i < userSentence.length(); i++) {
            if (Character.isDigit(userSentence.charAt(i))){
                System.out.println("number: "+ userSentence.charAt(i));
            }
        }
    }
}