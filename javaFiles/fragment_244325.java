String again; // <== declared here because conditions inside
              //     while cannot see variables defined inside the do {} block
do {
    System.out.print("Play Again? Yes/No: ");
    again = keyboard.nextLine();
} while (playAgain(again));