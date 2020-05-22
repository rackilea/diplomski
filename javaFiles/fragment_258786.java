public static void main(String[] args)
{
    //create scanner class
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to reverse number guessing game, pick a number between 1 and 100 and type it below:");
    int answer = sc.nextInt();
    sc.nextLine();   // This one is necessary to ignore everything on the same line as your number was typed in
    //Create the first guess
    int guess = 1 + (int)(100*Math.random());
    //Create an array that stores the range of the player's number
    int[] range = new int[] {1,100};
    //While loop that guesses the number
    while(guess != answer)
    {

        System.out.println("Is your number greater than or less than " + guess + "?" + Arrays.toString(range));
        String response = sc.nextLine();  // This reads the whole input line

        //Conditionals to set the range of the guess
        if(response.equals("less than"))
        {
            range[1] = guess;
        }
        else
        {
            range[0] = guess;
        }
        //Guess a new number based on the range
        guess = range[0] + (int)((range[1] - range[0]) * Math.random());
    }

    //Final print
    System.out.println("Your number was " + answer + ".\nThe computer's guess was: " + guess);
    //Close scanner
    sc.close();
}