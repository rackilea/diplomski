System.out.println("START GAME #" + gameNum);
int randCard = 1 + (int) (Math.random() * ((13 - 1) + 1));
System.out.println("Your card is a " + randCard + "!");
int playerHand = 0 + randCard;
System.out.println("Your hand is: " + playerHand);
do {
  System.out.println("1. Get another card");
  System.out.println("2. Hold hand");
  System.out.println("3. Print statistics");
  System.out.println("4. Exit");
  System.out.println("Choose an Option: ");
  int selectedOption = menuOptions.nextInt();

  if (selectedOption == 1) {
      randCard = 1 + (int) (Math.random() * ((13 - 1) + 1));
      System.out.println("Your card is a " + newRandCard + "!");
      System.out.println("Your hand is: " + (playerHand + newRandCard));
      playerHand = (playerHand + randCard);
  }
   ...other options to select
} while (playerHand <= 21) ;