public static void main(String[] args) {
    String input = null;
    try (Scanner scanner = new Scanner(System.in)) {
        while (true) {
            System.out.println("Please enter SOME INFORMATION:");
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
                if (inputIsSane(input)) break;
                System.out.println("Your input is malformed. Please try again.");
            }
        }
    }
    System.out.println("Got valid input. Input was: " + input);
    // continue with the rest of your program here
}

private static boolean inputIsSane(String input) {
    // replace with your actual validation routine
    return input.equals("let me pass");
}