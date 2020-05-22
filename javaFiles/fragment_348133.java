System.out.println("How much is in your purse?: ");


   purse = input.nextInt();
   boolean newBet = true;

    while(purse > 0)
    {
     if(newBet)
     {
      System.out.println("make a bet: ");
      bet = input.nextInt();
     }

     //roll the dice, new bet or not
     int pNumber = rand.nextInt(12) + 1;

     if ( pNumber == 2 || pNumber == 3 || pNumber == 12)
     {
            purse = purse - bet;
            System.out.println("you rolled a " + pNumber);
            System.out.println("you lost $" + bet);
            newBet =true; //make a new bet if you won
     }
     else if (pNumber == 7 || pNumber == 11)
     {
            purse = purse + bet;
            System.out.println("you rolled a " + pNumber);
            System.out.println("you won $" + bet );
            newBet=true; //make a new bet if you lost
     }
     else
     {
       System.out.println("you rolled a " + pNumber + ",keep rolling" );
       newBet=false; // make no new bet, neither won nor lost

     }
   } //end while


  System.out.println("Game over !")