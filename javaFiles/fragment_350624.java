public static int validateChoice(int floor, int roof) {
    String errorMessage = "Error: only numbers between " + floor 
            + " and " + roof + " are accepted";
    while (true) {
        while (!intScanner.hasNextInt()) {
            intScanner.next();
            System.out.println(errorMessage);
        }
        int choice = intScanner.nextInt();
        if (choice >= floor && choice <= roof) {
            return choice;
        }
        System.out.println(errorMessage);
    }
}