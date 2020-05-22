public class PigDice {

  static int dice1 = 0;
  static int dice2 = 0;
  static int player1Score = 0;
  static int player2Score = 0;
  static int player1Turn = 0;
  static int player2Turn = 0;
  static String input = "";
  final int maxScore = 100;
  boolean game = true;

  public static void main(String[] args) {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    do {
        do {

          System.out.println("PLAYER 1's TURN");
          System.out.println("Current score: " + player1Score);
          System.out.println("Number of turns taken: " + player1Turn);
          dice1 = random.nextInt(6) + 1;
          System.out.println("You rolled a: " + dice1);
          if (dice1 == 1) {
            System.out.println("You lose a turn and no points rewarded");
            System.out.println("Score: " + player1Score);
            System.out.println("");
            player1Turn++;
            break;
          } else {
            System.out.println("Would you like to roll again, or bank your points?");
            System.out.println("Enter 'r' to roll again, 'b' to bank.");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("b")) {
              player1Score += dice1;
              player1Turn++;
              System.out.println("Current player 1 score: " + player1Score);
              System.out.println("");
              break;
            } else if (input.equalsIgnoreCase("r") && dice1 != 1
                       && player1Score < 100) {
              player1Score += dice1;
              player1Turn++;
              System.out.println("Current player 1 score: " + player1Score);
              System.out.println("");

            }
          }

        } while (input.equalsIgnoreCase("r") || dice1 != 1);
        dice1 = 0;
        if (player1Score >= 100) {
          System.out.println("Player one wins");
          break;
        }


      do {
        System.out.println("PLAYER 2's TURN");
        System.out.println("Number of turns taken: " + player2Turn);
        System.out.println("Current score: " + player2Score);
        dice2 = random.nextInt(6) + 1;
        System.out.println("You rolled a: " + dice2);
        if (dice2 == 1) {
          System.out.println("You lose a turn and no points rewarded");
          System.out.println("Score: " + player2Score);
          player2Turn++;
          System.out.println("");
          break;
        } else {
          System.out.println("Would you like to roll again, or bank your points?");
          System.out.println("Enter 'r' to roll again, 'b' to bank.");
          String input = sc.nextLine();
          if (input.equalsIgnoreCase("b")) {
            player2Score = dice2 + player2Score;
            player2Turn++;
            System.out.println("Current player 2 score: " + player2Score);
            System.out.println("");
            break;
          } else if (input.equalsIgnoreCase("r") && dice2 != 1 && player2Score < 100) {
            player2Score += dice2;
            player2Turn++;
            System.out.println("Current player 2 score: " + player2Score);
            System.out.println("");

          }
        }

      } while (input.equalsIgnoreCase("r") || dice2 != 1);
      dice2 = 0;
      if (player2Score >= 100) {
        System.out.println("Player 2 wins");
        break;
      }

    } while (player1Score < 100 || player2Score < 100);
  }
}