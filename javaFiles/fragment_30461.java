public class BankAccount {
    private static final double annualInterestRate = 1.5;
    private static double accountBalance = 150;

    public static void main(String[] args) {
        double monthlyInterest = calculateMonthlyInterest();
        System.out.println(monthlyInterest);
    }

    public static double calculateMonthlyInterest() {
        return accountBalance * annualInterestRate;
    }
}