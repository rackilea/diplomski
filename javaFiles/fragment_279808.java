do{ 

    //user press a key to start the game
    System.out.println("Press enter");
    new Scanner(System.in).nextLine();

    //player new roll, location, and balance
    newRoll = roll(); //roll of the dice
    newLoc = newLoc + (newRoll - 1); //player position

    //necessary to keep the game going until player balace is 0
    if(newLoc > pos.length-1)
    {
      newLoc = (pos.length-1) - newLoc;//player new loc if > 39
    }

    newPos = pos[newLoc]; //info about location
    newBal = newBal - newPos.getRent(); //player new balance

    //prints info on screen
    System.out.println(newRoll() + " " + newLoc + " " + newBal);   


   }while (newBal > 0);//loop until player balance get to zero