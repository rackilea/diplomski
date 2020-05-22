int rounds = 1;

do {

// codes that you want to loop
System.out.println("Welcome" + "" + player + "" + "To Dice Game");
System.out.println("Round " + rounds); // this will annouce the number of rounds
System.out.println("Enter Y to Roll or R to STop:[Y or R]")
playerAnswer = user.nextLine();
rounds++;

} while (playerAnswer.equalsIgnoreCase("y");