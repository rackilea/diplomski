for(int i = 1; i <= numberOfGuesses; i++){
   System.out.print("Enter guess #"+i+": ");
   guess = scan.nextInt();
        if (guess > randomNumber)
                    System.out.println("Your guess, "+guess+", is greater than the magic number.");
        else if (guess < randomNumber)
                    System.out.println("Your guess, "+guess+" is less than the magic number.");
        else if (guess == randomNumber){
                    System.out.println("Congratulations, "+name+"! You guessed the magic number in "+i+" guesses.");
                    break;
                }
        if (i == numberOfGuesses)
             System.out.println("Sorry, "+ name+"you did not guess the magic number,"+ randomNumber+"in"+numberOfGuesses+ "tries.");

    }