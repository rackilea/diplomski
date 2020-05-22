int val = -1;
do {
    System.out.print("Enter an int: ");
    if (scanner.hasNextInt()) {
        val = scanner.nextInt();
    } else {
        scanner.nextLine();
    }
} while (val < 0 || val >= 10);