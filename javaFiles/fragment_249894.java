if(myGuess == thisRandomInt && attempt <= guess.length){
    done = true;
    System.out.println("You won. It took " + attempt+ " times to guess my number.");
}else if (attempt >= guess.length){
    System.out.println("Game Over. My number is "+thisRandomInt );
    done = true;
}else if (myGuess < thisRandomInt){
    guess[attempt-1] = myGuess;
    System.out.println("Guess a higher number");
}else{
    guess[attempt-1] = myGuess;
    System.out.println("Guess a lower number");
}