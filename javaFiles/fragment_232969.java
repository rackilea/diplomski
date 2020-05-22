Random generator = new Random(); 
Scanner input = new Scanner(System.in);

int numberToGuess = 1 + generator.nextInt(100); 
int numberOfTries = 0;
int limit= 10;
int guess;
System.out.println ("You have 10 tries to guess a number between 1 and 100");

while(numberOfTries < 10){
    System.out.print("Guess number " + numberOfTries + ": ");
    guess= input.nextInt();
    if (guess < numberToGuess)
         System.out.println("Your guess is too low. Try again.");

    else if (guess > 100)
        System.out.println("Guesses should be between 1 and 100.");
    else if (guess > numberToGuess)
        System.out.println("Too high. Try again.");
    else if (guess == numberToGuess){
        System.out.println("Congratulations!");
        break;
        }
    numberOfTries++;
}