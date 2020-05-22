String guess;
Scanner keyboard = new Scanner(System.in);

Random r = new Random();
char answear = r.nextBoolean() ? 'R' : 'B';
String s = String.valueOf(answear);

do {
    System.out.println("Guess the color of the card - (R)ed or (B)lack?");
    guess = keyboard.next();
    //The problem is that you're using reference comparison, but that's not the only issue you 'will have', you're only checking raw input vs upper case 'R' 
    //and 'B' so you 'need' (you can handle this with lower case or alternative, too) to change this to `.toUppercase()`.
    if (guess == s)
        System.out.println("Correct");
    else
        System.out.println("Wrong");
//The same problem is happening here:
} while (guess != s);