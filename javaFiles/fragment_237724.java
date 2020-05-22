private static double computeCompoundInterest(double principal, double rate,
                                              double years) {
    return principal * Math.pow(1 + rate, years);
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("I am a savings account interest calculator.");

    System.out.println("How much money have you deposited?");
    double principal = scanner.nextDouble();

    System.out.println("Now, what is the annual interest rate? (i.e. .05)");
    double rate = scanner.nextDouble();

    System.out.println("How many years will you hold that money in the account?");
    double years = scanner.nextDouble();

    double total = computeCompoundInterest(principal, rate, years);

    System.out.format("Your balance at the end of that period will be %.2f.\n", years, total);
}