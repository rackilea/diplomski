boolean userCorrect = false;
int roundNumber = 1;  // starting round

while (!userCorrect) {

    Scanner input = new Scanner(System.in);
    System.out.print("Guessing (round " + roundNumber + "): Choosing your letter from a-z: ");
    String letter = input.nextLine();

    if (letter.length () > 1) {
        System.out.println("You should not enter more than 1 character");
    }

    else{
        System.out.println("end of (round " + roundNumber + ")");
        roundNumber++;       // now increment
    }
}