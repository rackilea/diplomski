String guess;
Scanner keyboard = new Scanner(System.in);

Random r = new Random();
char answear = r.nextBoolean() ? 'R' : 'B';
String s = String.valueOf(answear);

do {
    System.out.println("Guess the color of the card - (R)ed or (B)lack?");
    guess = keyboard.next();
    if (guess.toUpperCase().equals(s))
        System.out.println("Correct");
    else
        System.out.println("Wrong");
} while (!guess.toUpperCase().equals(s));}