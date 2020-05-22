//The loop controlling the game   
while (playGame == 'y') {
        if (playGame != 'y')
            break;

        randomNumber = generator.nextInt(MAX) + 1;
        //Creating a flag to control the inner loop
        int correct = 0;

        //The loop to control the round.
        while (correct == 0){
            System.out.println("Please pick a number between 1 and 100.");
            userNumber = scan.nextInt();

            // high and low sugguestion
            if (userNumber > randomNumber)
                System.out.println("Number is too high, try something lower.");
            if (userNumber < randomNumber)
                System.out.println("Number is too low, try something higher.");
            if (userNumber == randomNumber) {
                System.out.println("That number is correct!");
                correct = 1;
                System.out.println("Would you like to play again? y/n");
                playGame = scan.next().charAt(0);
            }            

            // counter to keep running total of times guessed
            guesses++;
            System.out.println("You have guessed " + guesses + " times!");
        }

    }