import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
   private static Random random = new Random();
   private static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      RPS compChoice = RPS.values()[random.nextInt(RPS.values().length)];
      RPS userChoice = getUserChoice();

      String result = "";
      switch (userChoice.test(compChoice)) {
      case 1:
         result = "you win!";
         break;

      case -1:
         result = "you lose!";
         break;

      case 0:
         result = "it's a tie";

      default:
         break;
      }
      System.out.printf("You chose %s, the computer chose %s, %s%n",
            userChoice, compChoice, result);
   }

   private static RPS getUserChoice() {
      System.out.print("Please select one of [R/P/S]: ");
      String userChoiceStr = in.nextLine().trim();
      if (userChoiceStr.isEmpty()) {
         return RPS.ROCK;
      }
      for (RPS rps : RPS.values()) {
         if (rps.toString().startsWith(userChoiceStr.toUpperCase())) {
            return rps;
         }
      }

      return RPS.ROCK; // default
   }
}