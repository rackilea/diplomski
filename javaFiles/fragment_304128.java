public static String validatePassword(String password) {
    String validatePassword = "";
    boolean oneUpperCase = false;
    boolean oneDigit = false;
    boolean exit = false;
    final String SENTINEL = "Q";
    Scanner in = new Scanner(System.in);

    while (!exit && (!oneUpperCase || !oneDigit || password.length() < 8)) {
        validatePassword = "Please try again or enter Q to quit: ";
        System.out.print(validatePassword);
        password = in.next();

        oneUpperCase = !password.equals(password.toLowerCase());
        oneDigit = password.matches(".*\\d.*");
        exit = password.equals(SENTINEL);
    }
    validatePassword = "Password Ok";

    System.out.print("Quit");
    return validatePassword;
}