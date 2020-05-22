import java.util.Scanner;

public class GuessTheLetterGame {

    public static void main(String[] args) throws java.io.IOException{
        Scanner keyboard = new Scanner(System.in);
        char answer;
        char guess;
        boolean right = false;

        while(!right){

            System.out.print("press a key and press ENTER:");
            answer= (char) keyboard.next().charAt(0);

            System.out.print("Have a guess and press ENTER: ");
            guess= (char) keyboard.next().charAt(0);
            if (guess == answer){
                System.out.println("**Right**");
                right = true;
            }
        }
    }
}