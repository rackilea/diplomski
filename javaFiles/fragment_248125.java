import java.util.Scanner;
import java.util.Random;

public class HiLoGame {

    public static void main(String[] args) {
        Random generator = new Random();
        Scanner input = new Scanner(System.in);
        String guess = null, result = null;
        Boolean won = false;
        int nextCard, card = 3, count = 0;
        System.out.println("Current card is: " + card);
        switch (card) {
            case 11:
                System.out.println("Which means it is card jack!");
                break;
            case 12:
                System.out.print("which means it is card queen!");
                break;
            case 13:
                System.out.print("which means it is card king!");
                break:
            case 14:
                System.out.println("Which means it is card Ace!");
                break;
        }

        System.out.println("WELCOME! to High-Low game.\nGuess four times in a row to win.");

        while (!won) {

            nextCard = generator.nextInt(14) + 1;

            System.out.println("You current card is: " + card + "\nWill the next card be high, low or equal?");

            guess = input.next().toLowerCase();
            System.out.println("The next card is:" + nextCard);

            if(card<nextCard){
                result = "high";
            }
            else if(card>nextCard){
                result = "low";
            }
            else if(card==nextCard){
                result = "equal";
            }

            if(guess.equals(result)){
                System.out.println("NICE GUESS\nKEEP PLAYING");
                card = nextCard;
                count++;
            }
            else {
                System.out.println("Sorry WRONG GUESS!\nBetter luck next time");
                count=0;
            }

            if(count==4){
                System.out.println("Congratulations, you have beaten the game!!!\nWould you like to play again? Yes/No");
                guess = input.next().toLowerCase();
                if(guess.equals("yes"))
                {
                    count = 0;
                    card = generator.nextInt(14) + 1;
                }
                else{
                    System.out.println("Thank you for playing, goodbye");
                    System.exit(0);
                }

            }
        }
    }
}