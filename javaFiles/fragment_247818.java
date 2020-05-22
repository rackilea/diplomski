do {
    valid = true;
    System.out.println("Enter wall height (feet): ");
    if (scnr.hasNextDouble()) {
        wallHeight = scnr.nextDouble();
        if (wallHeight <= 0) {
            System.out.println("Invalid Input");
            valid = false;
        }
    } else {
        System.out.println("Invalid Input " + scnr.nextLine());
        valid = false;
    }
} while (!valid);