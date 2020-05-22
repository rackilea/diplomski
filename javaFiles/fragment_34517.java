while(true) {
    computerValue = randomNumber.nextInt(100);
    numberOfTries = 0;
    while (true) {
        System.out.println("please enter an integer betwen 1 and 100 inclusive: ");
        guess = kbd.nextInt();
        numberOfTries++;

        if (guess < 1 || guess > 100) System.out.println("Invalid input");
        else if (guess == computerValue) {
            System.out.println("Congratulations you won! Your numbers of tries was: " + numberOfTries + " and the number was: " + computerValue);
            // leave the first loop
            break;
        }
        else if (guess < computerValue) System.out.println("Your guess is too low!");
        else if (guess > computerValue) System.out.println("Your guess is too high!");
    }

    System.out.println("Do you want to play again? (1:Yes/2:No)");
    // if input is not yes leave second loop
    if(kbd.nextInt() != 1) break;
}