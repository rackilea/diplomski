int guess = -1; // This will be an invalid input
try{
    guess = keyboard.nextInt();
}catch (InputMismatchException e){
    // Because guess is already -1, "invalid" will be printed out by 
    // Below if statements
}