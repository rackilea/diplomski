public static double solvingForMass(Scanner in) {

    System.out.println("Please enter a value for force.");
    double f = in.nextDouble();

    System.out.println("Please enter a value for acceleration.");
    double a = in.nextDouble();

    return f / a;

}