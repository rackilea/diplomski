public class GuessTheNumber 
{
private Scanner input = new Scanner(System.in);
private SecureRandom randomNumbers = new SecureRandom();
private int numberOfGuesses;

public void play() {
    numberOfGuesses = 0;
    int magicNumber = 1 + randomNumbers.nextInt(10);

    int guess = 0;

    while(guess != magicNumber){
    // Some kind of loop, maybe while
    guess = askForGuess();
    // is theGuess equal to magicNumber or is it

    if (guess == magicNumber)
    System.out.println("Yes, the number is " + magicNumber);

  else if (guess > magicNumber)
    System.out.println("Your guess is too high");

  else if (guess < magicNumber)
    System.out.println("Your guess is too low");

          System.out.println  ("Number of times guessed: " + numberOfGuesses );
    }

  }

private int askForGuess( ) 
{
    int guess = 0;
     // prompt for a guess
    System.out.println("Enter a number:");

    guess = input.nextInt();

    if (guess <1 || guess >10 )
        System.out.println ("Your guess needs to be between 1 and 10");
    else
        numberOfGuesses++;

  return guess;
}

}