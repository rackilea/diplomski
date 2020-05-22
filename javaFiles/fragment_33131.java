public class Example {
    public static void main(String[] args) {
        double myMonthlyPayment = 2000;
        double myAnnualInterestRate = 5;
        double myPrincipal = 200000;
        System.out.println(a(myMonthlyPayment));
        System.out.println(b(myPrincipal, myAnnualInterestRate, myMonthlyPayment));
        System.out.println(c(myAnnualInterestRate));
        double monthsNeeded = (a(myMonthlyPayment) - b(myPrincipal, myAnnualInterestRate, myMonthlyPayment))
                / c(myAnnualInterestRate);
        System.out.println(monthsNeeded);
    }

    private static double c(double myAnnualInterestRate) {
        return Math.log((myAnnualInterestRate / 1200.0) + 1);
    }

    private static double b(double myPrinicipal, double myAnnualInterestRate, double myMonthlyPayment) {
        return Math.log(myMonthlyPayment - (myAnnualInterestRate / 1200.0) * myPrinicipal);
    }

    private static double a(double myMonthlyPayment) {
        return Math.log(myMonthlyPayment);
    }
}