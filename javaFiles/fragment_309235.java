public static void main(String... args) {

    String[] verifiedNames = { "barry", "matty", "olly", "joey" };
    System.out.println("choose an option");
    System.out.println("Uselift(1)");
    System.out.println("see audit report(2)");
    System.out.println("Exit Lift(3)");

    Scanner scanner = new Scanner(System.in);
    int choice = scanner.nextInt();

    switch (choice) {
    case 1:
        scanner.nextLine(); // get '\n' symbol from previous input
        int nameAttemptsLeft = 3;
        while (nameAttemptsLeft-- > 0) {
            System.out.println(" Enter your name ");
            String name = scanner.nextLine();

            if (Arrays.asList(verifiedNames).contains(name)) {
                System.out.println("dear " + name + " you are verified " +
                        "you may use the lift, calling lift ");
                break; // break out of loop
            }
        }
        if (nameAttemptsLeft < 0) {
            System.out.println("Username Invalid");
        }
        break;

    case 2:
        System.out.println("option 2");
        break;
    case 3:
        System.out.println(" Please Exit Lift ");
        break;
    }

    scanner.close();

}