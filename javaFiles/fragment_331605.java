import java.util.Scanner;
import java.util.Random;
public class CrapsGame {
    //generates random number to be used in method rollDice
    private Random randomNumbers = new Random();

    //enumeration of constants that represent game status
    private enum Status {WIN, LOSE, CONTINUE};

    //represents possible outcomes of rolling the dice
    private final static int two = 2;
    private final static int three = 3;
    private final static int seven = 7;
    private final static int eleven = 11;
    private final static int twelve = 12;

    public static void main (String[]args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter a player name: ");
        String playerName = sc.nextLine();
        CrapsGame game = new CrapsGame(); //created object of class "CrapsGame"
        game.playgame(playerName); //tells CrapsGame object "game" to invoke"playgame" method
    }
    //method to play game
    public void playgame(String playerName) {
        int currentPoint = 0; //holds point value for current roll
        Status gameResult; //contains one of enumeration values
        int sumofDice = rollDice(playerName); //sum after first roll
        //determines if won, lost, or continue
        switch (sumofDice)
        {
            case seven:
            case eleven:
            gameResult = Status.WIN;
            break;
            case two:
            case three:
            case twelve:
            gameResult = Status.LOSE;
            break;
            //game continues if above conditions are not met
            default:
            gameResult = Status.CONTINUE;
            currentPoint = sumofDice;
            System.out.printf("Point is %d\n", currentPoint);
        }

        while (gameResult == Status.CONTINUE)
        {
            sumofDice = rollDice(playerName);
            if (sumofDice == currentPoint)
                gameResult = Status.WIN;
            else if (sumofDice == seven)
                gameResult = Status.LOSE;
        }
        if (gameResult == Status.WIN)
            System.out.println(playerName + " wins");
        else 
            System.out.println (playerName + " loses");
    }
    public int rollDice(String playerName)
    {
        //choose a random number from 1-6
        int firstroll = 1 + randomNumbers.nextInt(6);
        int secondroll = 1 + randomNumbers.nextInt(6);
        int sum = firstroll + secondroll;
        System.out.printf("%s rolled %d and %d for a total of %d\n", playerName, firstroll, secondroll, sum);
        return sum;
    }
}