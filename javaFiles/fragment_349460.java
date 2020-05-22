int menuChoice = -1;
do {

    //....

    menuChoice = scan.nextInt();

    switch(menuChoice)
    {
        case 1:System.out.println("Loading Zest Quest");
        break;
        case 2:System.out.println("This is a text based game.It is based on player choice.Your choices will matter so choose carefully");
                    System.out.println("You can interact with items and objects by typing examine,pick up,attack and other words.");
                    System.out.println("If you are having any trouble with a spefic parts check the cheat sheet provided.");enter code here
                    System.out.println("");
        break;
        case 3:System.out.println("Goodbye my friend");
    }

} while(menuChoice != 3);