private static String mainMenu(Scanner scan){
    String menu = "\n" + "A. List the pets in the store." +
            "\n" + "B. Age up the pets" +
            "\n" + "C. Add a new pet" +
            "\n" + "D. Adopt a pet" +
            "\n" + "E. Quit";

    System.out.println("Type the letter to make your selection." + menu);
    char letter = Character.toUpperCase((scan.next().charAt(0)));

    // Check if letter is valid. If not, ask the user to input another letter.
    while (!(letter >= 'A' && letter <= 'E')){
        System.out.println("That is not one of the options. Input another letter.");
        letter = Character.toUpperCase((scan.next().charAt(0)));
    }

    return letter + "";
}