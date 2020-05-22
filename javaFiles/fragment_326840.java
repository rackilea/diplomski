// Utilities
    Scanner in = new Scanner(System.in);

    // Variables
    double height = 0.0;
    double weight = 0.0;
    boolean error = false;
    double bmi = 0.0;
    System.out.println("Enter height in inches:");
    while (height <= 0) {
        try {
            height = in.nextDouble();
        } catch (InputMismatchException e) {
            height = -1;
            System.out
                    .println("Invalid inches value. Must be a decimal number.");
            System.out.println("Re-enter height in inches:");
            in.nextLine();
            error = true;
        }
    }

    System.out.println("Enter weight in inches:");
    while (weight <= 0) {
        try {
            weight = in.nextDouble();
        } catch (InputMismatchException e) {
            weight = -1;
            System.out
                    .println("Invalid inches value. Must be a decimal number.");
            System.out.println("Re-enter weight in inches:");
            in.nextLine();
            error = true;
        }
    }
    // bmi calculation
    bmi = (weight / (height * height)) * 703;

    // Outputs
    System.out.println("Height = " + height + ".");
    System.out.println("Weight = " + weight + ".");
    System.out.println("Body mass index = " + bmi + ".");
}