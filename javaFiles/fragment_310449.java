public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter your password (4 to 12 characters)"); // Prompt the user

    boolean valid = false;
    while (!valid) {
        String password = in.nextLine();
        if (password.length() > 3 && password.length() < 13) {
            valid = true; // Length between 4 and 12, we can stop asking.
            System.out.println("Your password is " + password);
        } else {
            System.out.print("Please enter a valid password: "); // Invalid length, ask again.
        }
    }

    in.close();
}