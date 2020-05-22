public static boolean getValidContinueCode(Scanner sc, String prompt) {
    while (true) {
        System.out.print(prompt);

        if (sc.next().equalsIgnoreCase("y")) {
            return true;
        }
        else if (sc.next().equalsIgnoreCase("n")) {
            return false;
        }
        else {
            System.out.println("Please enter y or n");
        }
    }
}