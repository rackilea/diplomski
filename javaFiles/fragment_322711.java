} else { 
    for (i = bet; i > 0; i--) {
        int num = gen.nextInt(100000) + 1;
        System.out.print(num + "\t");
        if (isPrime(num)) {
            // i = 0; // don't reset i here
            System.out.println("You found a prime!!");
            bet = bet * 3;
            balance += bet;
            System.out.println("You won " + bet);
            System.out.println("Current balance: " + balance);
            ans = readNum("Would you like to continue playing? (1:yes/0:no)");
            if (ans == 0) {
                playing = false;
            }
            break; // start from outer while loop again; (i is > 0 here)
        }
    }
    if (i == 0) { // i.e. no prime was generated
        ans = readNum("\nSorry, you lost. Would you like to play again? (1:yes/0:no)");
        System.out.println("Current balance: " + balance);
        if (balance == 0) {
            System.out.println("Out of credits! Goodbye!");
            playing = false;
        }
    }
}