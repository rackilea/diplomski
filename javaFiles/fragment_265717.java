System.out.println("Please choose either Applaro, Svartra, Tunholmen, or Godafton.");
boolean temp = true;
String playerPick = "";
    while (temp) {
        playerPick = console.next();
        if (playerPick.equals("Applaro") || playerPick.equals("Svartra") || playerPick.equals("Tunholmen") || playerPick.equals("Godafton")) {
            System.out.println("You have picked " + playerPick);
            temp = false;
        }
        else
            System.out.println("Please enter a valid input.");
    }