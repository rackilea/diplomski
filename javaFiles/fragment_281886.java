private static String nextMove(Scanner in) {
    String input = "";
    do {
        System.out.print("Please enter move: ");
        input = in.nextLine().trim().toLowerCase();
    } while (input.isEmpty() || input.length() != 1 || !"abc".contains(input));
    return input;
}