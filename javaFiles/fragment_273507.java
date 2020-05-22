public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);

    int switchNumber;
    String variableCaseOne;
    double initialVelocity;
    double time;

    System.out.println("This section is for projectile motion.");
    System.out.println("Which equation would you like to use?");
    System.out.println("1. Horizontal Equation: D = Vi * t");
    System.out.println("2. Vertical Equation: D = Vi * t - (1/2)g * (t^2)");
    switchNumber = input.nextInt();
    if (switchNumber == 1)
    {
        System.out.println("Tell me which variable you'd like to solve for.");
        variableCaseOne = input.next();
        if (variableCaseOne.equals("d"))
        {
            System.out.println("Enter the Initial velocity.");
            initialVelocity = input.nextDouble();
            System.out.println("Enter the time.");
            time = input.nextDouble();
            System.out.println("Distance equals: " + initialVelocity * time);
        }
    }
    input.close();
}