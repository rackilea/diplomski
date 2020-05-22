public class BankAccount {
    private static final double annualInterestRate = 1.5;
    private static double accountBalance = 150;
    private static double monthlyInterest;

    public static void main(String[] args) {
        calculateMonthlyInterest();
        System.out.println(monthlyInterest);
    }

    public static void calculateMonthlyInterest() {
        monthlyInterest = (accountBalance * annualInterestRate);
    }
}