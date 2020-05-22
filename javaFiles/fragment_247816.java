do {
    valid = true;
    try {
        System.out.println("Enter wall height (feet): ");
        wallHeight = scnr.nextDouble();
        if (wallHeight <= 0) {
            throw new Exception("Invalid Input");
        }
    } catch (Exception e) {
        valid = false;
        System.out.println("Invalid Input");
    }
} while (!valid);