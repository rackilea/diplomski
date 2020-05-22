static int getUserChoice() {
    int choice;

    System.out.print("Please enter your choice: ");
    choice = keyboard.nextInt(); // consume just the integer

    // consume the rest of the line
    keyboard.nextLine();

    return choice;
}