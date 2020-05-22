public class ProgramBlackJack
{

  public static void main(String[] args)throws IOException
  {
    Scanner in;
    in = new Scanner(System.in);

    int money;
    int bet;            // Amount user bets on a game.
    boolean userWins = true;   // Did the user win the game?

    System.out.println("Welcome to Lunas BlackJack table. How's it goin?");
    System.out.println();

    money = 100;  // User starts with $100.

    while (true)
    {
      System.out.println("You have " + money + " dollars.");
      do
      {
        System.out.println("How much do you wanna bet? Or if you're done, enter 0 to walk away from the tables.)");
        System.out.print("$");

        bet = in.nextInt();
        if (bet < 0 || bet > money)
        {
          System.out.println("Your bet must be between 0 and " + money + '.');
        }
      }
      while (bet < 0 || bet > money);
      {
        if (bet == 0)
        {
          System.out.println("The dealer waves goodbye.");
          break; //walk away
        }

        userWins = playBlackjack();
        if (userWins == true)
        {
          money = money + bet;
        }
        if (userWins == false)
        {
          money = money - bet;
          System.out.println();
        }
        if (money == 0)
        {
          System.out.println("Aw shoot, looks like you've are out of money!");
          break;
        }
      }
    }

    System.out.println();
    System.out.println("You walk away with $" + money + '.');

  } //end method


  public static boolean playBlackjack()
  {
    String anotherCard;
    String playAgain = "y";
    String ctn;

    int nextCard;
    int card1;
    int card2;
    int dCard1;
    int dCard2;
    int cardTotal = 0;
    int dTotal = 0;

    Scanner in = new Scanner(System.in);
    Random random = new Random();

    // Begin dealing the players first two cards

    if (playAgain.equals("y"))
    {
      //dealers first two random cards
      dCard1 = random.nextInt(11) + 1;
      dCard2 = random.nextInt(11) +1;

      //players first two random cards and card total
      card1 = random.nextInt(11) + 1;
      card2 = random.nextInt(11) + 1;
      cardTotal = card1 + card2;

      //Dealers two card total and display only one dealer card
      dTotal = dCard1 + dCard2;
      System.out.println("The dealer shows: " + dCard1);

      //Display players first two cards & card total
      System.out.println("First cards: " + card1 + ", " +card2);
      System.out.println("Total: "+ cardTotal);

      //Asks if want to deal another card
      System.out.print("Another card (y/n)?: ");
      anotherCard = in.nextLine();

      //If yes
      while (anotherCard.equals("y"))
      {//while1
        nextCard = random.nextInt(10) + 1;
        cardTotal += nextCard;
        System.out.println("Card: " + nextCard);
        System.out.println("Total: " + cardTotal);

        if (cardTotal > 21)
        {//if1
          System.out.println("You busted, the dealer Wins");
          System.out.println("Do you want to play again? (y/n): ");
          playAgain = in.nextLine();
          return false;
        }//if1

        if (cardTotal < 21)
        {//if2
          System.out.print("Another Card (y/n)?: ");
          anotherCard = in.nextLine();
        }//if2

        if (anotherCard == "n")
        {//if3

          System.out.print("Press c to continue dealers cards");
          ctn = in.nextLine();

          while (ctn == "c" && dTotal < 17)
          {//while2
            nextCard = random.nextInt(10) + 1;
            dTotal += nextCard;
          }//while2

          if (dTotal > 21)
          {//if4
            System.out.println("Dealer Busts, You Win!");
            System.out.println("Play Again? (y/n): ");
            playAgain = in.nextLine();
            return false;
          }//if4

          if (playAgain.equalsIgnoreCase("y")) //ignorecase = ignore capitals/lowercase
          {//if5
            playAgain = "y";
          }//if5

          if (playAgain.equalsIgnoreCase("n")) //no!
          {//else1
            System.exit(0);
          }//else1
        }//if3

      }//while1
    }//END BIG WHILE
    return true;
  }//end playBlackJack()
} //end main