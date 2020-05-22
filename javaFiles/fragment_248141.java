public static void main(String args[]) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Please enter a word: ");
    String input = keyboard.nextLine();

    System.out.print("Please enter a letter to search in the word: ");
    Scanner keyboard1 = new Scanner(System.in);
    char letter = keyboard1.nextLine().charAt(0);

    // Using toLowerCase() to ignore capital vs lowercase letters.
    // Locale may need to be considered.
    if (input.toLowerCase().contains(String.valueOf(letter).toLowerCase())) { 
        System.out.println("The word does contain the letter " + letter + ".");
    } else {
        System.out.println("The word does not contain the letter " + letter + ".");
    }
}