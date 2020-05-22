System.out.printf("%5s %3d %3d %3d %3d %3d %3d %3d %3d %3d %3d%n", "", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    System.out.println("-------------------------------------------------");

    // Nested For loops to build multiplication table
    for (int number1 = 1; number1 <= 10; number1++) {
        System.out.printf("%3d | ", number1);

        for (int number2 = 1; number2 <= 10; number2++) {
            System.out.printf("%3d ", (number1 * number2));
        }
        System.out.println("  | ");
    }