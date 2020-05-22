/**
 * This method will return true for yes and false for no.
 * It is private, because it is unnecessary for other
 * Classes to use it.
 */
private boolean sayYes(String text){
    Scanner keyboard = new Scanner(System.in);
    while(true){
        System.out.print(text);
        // Gets keyboard input, trims it, and makes it lower case.
        String input = keyboard.nextLine().trim().toLowerCase;
        // Checks for "Yes"
        if(input.equals("y") || input.equals("yes"))
            return true;
        // Checks for "No"
        if(input.equals("n") || input.equals("no"))
            return false;
        // If we got here, then it was neither a "yes" or "no",
        // so we complain, and go around the loop again
        System.out.println("Invalid input.");
    }
    // The keyboard Scanner is not closed so the program can
    // continue to receive keyboard input from other places.
}