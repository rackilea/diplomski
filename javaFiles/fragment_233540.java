while(guess != numberOfItems){
    try{
        if(guess>maxNumberOfItems){
            throw new IllegalArgumentException();
        } else if (guess<1){
            throw new IllegalArgumentException();
        }
    } catch(IllegalArgumentException iae){
        System.out.println("Please choose a valid number");
    }

    prompter.tryAgain();
    guess = scanner.nextInt();
    numberOfGuesses++;
}