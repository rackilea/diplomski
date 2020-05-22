int val = scanner.nextInt();
do {
    if (val < 5) {
        // too low
        val = scanner.nextInt();
    } else if (val > 5) {
        // too high
        val = scanner.nextInt();
    } else {
        // correct
        // THIS CODE DOESN'T RUN?!
    }
} while (val != 5);