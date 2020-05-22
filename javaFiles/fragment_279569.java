Scanner input = new Scanner(System.in);
int roundNumber = 1;
boolean isUserCorrect = false;

String selected = "";

while (true) {
    System.out.print("Guessing (round " + roundNumber + "): Choosing your letter from a-z: ");
    String letters = input.nextLine();

    if (letters.length () > 1) { //code will print an error if the user selects more than 1 character
        System.out.println("You should not enter more than 1 character");
        continue;
    }

    if (selected.contains(letters)) {
        System.out.println(letters + " has been chosen before, try again");
        continue;
    }

    selected = selected.concat(letters);
    System.out.println("end (round " + roundNumber + ")");
    roundNumber++;
    if (roundNumber > 5) {
        System.out.println("Selected characters: " + selected);
        break;
    }
}
input.close();