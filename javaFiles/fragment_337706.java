while (selection < 1 || selection > 5) {
    System.out.println("1. Display all books");
    System.out.println("2. Add a book");
    System.out.println("3. Delete a book");
    System.out.println("4. Exit the program");

    while (!keyboard.hasNextInt()) {
        keyboard.next();
        System.out.println("Re-Enter an integer value");
    }
    selection = keyboard.nextInt();
}