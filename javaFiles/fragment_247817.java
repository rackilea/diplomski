do {
    valid = true;
    System.out.println("Enter wall height (feet): ");
    wallHeight = scnr.nextDouble();
    if (wallHeight <= 0) {
        System.out.println("Invalid Input");
        valid = false;
    }
} while (!valid);