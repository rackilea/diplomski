import java.util.Random; //Not used in your code, no need to import

public class Dice {

 public static void main(String[] args) {
    int turn;
    turn = (int) (Math.random() * 2 + 1);
    int score1 = 0;
    int score2 = 0;
    int roll1 = 0;
    int roll2 = 0;

  while (score1 <= 75 || score2 <= 75){

    if (turn == 1 & (roll1 != roll2)) {
        //roll1 = roll1.random(); //please correct this
        //roll2 = roll2.random(); //put correct code that you want
        score1 += (roll1 + roll2);
        System.out.println("Player 1 rolls a" + roll1 + "and a" + roll2);
        turn = 2;
    }

    else if (roll1 == roll2) {
        while (roll1 == roll2) {
         System.out.println("Player 1 gets to roll again");
         //roll1 = roll1.random();
         //roll2 = roll2.random();
         score1 += (roll1 + roll2);
         System.out.println("Player 1 rolls a" + roll1 + "and a" + roll2);
         score1 += (roll1 + roll2);
        }
     } 

      else {
        if (score1 >= 75) {
         System.out.println("Player 1 wins!");
         turn = 2;
        }
     }


    if (turn == 2 & roll1 != roll2) {
        //roll1 = roll1.random();
        //roll2 = roll2.random();
        score2 += (roll1 + roll2);
        System.out.println("Player 2 rolls a" + roll1 + "and a" + roll2);
        turn = 1;
    }

    else if (roll1 == roll2) {
          while (roll1 == roll2);
          System.out.println("Player 2 gets to roll again");
          score2 += (roll1 + roll2);
          //roll1 = roll1.random();
          //roll2 = roll2.random();
          System.out.println("Player 2 gets to roll again");
     } 
    else {
          if (score2 >= 75) {
           System.out.println("Player 2 wins!");
           turn = 1;
          }
     }

  }

 }

}