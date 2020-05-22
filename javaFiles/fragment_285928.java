while (true) {
    System.out.print("Enter numbers: ");
    String input = scanner.nextLine();
    try {
        final long sum = Arrays.stream(input.split("\\s+"))
            .mapToLong(Long::parseLong)
            .reduce((left, right) -> left * right)
            .getAsLong();
        System.out.println("Result: " + sum);
    } catch (NumberFormatException e) {
        System.out.println("Only enter numbers!");
    }
    System.out.println("Play again? Enter 'Y' or 'N'");
    if (scanner.nextLine().equalsIgnoreCase("n")) {
        break;
    }
}