try (Scanner scanner = new Scanner(System.in)) {
    while (!scanner.hasNextInt()) {
        System.err.println("Try again, this time with a proper int");
        scanner.next();
    }
    gridSize = scanner.nextInt();
}