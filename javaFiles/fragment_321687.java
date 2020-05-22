Scanner in = new Scanner(System.in);
System.out.print("Loan Amount: ");
double loanAmount = in.nextDouble();
System.out.print("Number of Years: ");
int years = in.nextInt();

// Unused variables...
// int lastMonth = years * 12;
// int month = 1;

for (double annualInterestRate = 5.0; annualInterestRate <= 8.0; annualInterestRate += 0.125) {
    double monthlyInterestRate = annualInterestRate / 1200;
    double monthlyPayment = loanAmount * monthlyInterestRate /
            (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
    double totalPayment = monthlyPayment * 12 * years;

    System.out.println("Interest Rate\tMonthly Payment\tTotal Payment");
    System.out.printf("%.03f%%\t$%.02f\t$%.02f\n", annualInterestRate, monthlyPayment, totalPayment);
}