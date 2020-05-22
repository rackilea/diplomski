public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int guesses = guess(input);
    System.out.println("You got it correct after " + guesses + " tries");
}

public static int guess(Scanner input)
{
    String prompt = "Enter your guess (integer from 1 to 10)";
    Random randomNumber = new Random();
    numToGuess = randomNumber.nextInt(10) + 1;    //+1 to make it 1-10 inclusive
    numTries = 0;

    while (getInt(input, prompt) != numToGuess)
    {
        numTries++;
    }

    return numTries;
}

public static int getInt(Scanner input, String prompt)
{
    int userGuess = -1;
    boolean valid = false;
    System.out.println(prompt);

    while (!valid)
    {
        try
        {
            userGuess = input.nextInt();
            valid = true;
        }
        catch (NumberFormatException e)
        {
            System.out.println("You did not enter an int. Try again");
        }
    }

    return userGuess;
}