public static String getValidContinueCode(Scanner sc, String prompt) {
    String choice = "";
    boolean isValid = false;

    while (!isValid) {
        System.out.print(prompt);

        choice = sc.next();
        if (choice.equalsIgnoreCase("y")) {
            isValid = true;
        }
        else if (choice.equalsIgnoreCase("n")) {
            isValid = true;
        }
        else {
            System.out.println("Please enter y or n");
        }
    }
    return choice;

}