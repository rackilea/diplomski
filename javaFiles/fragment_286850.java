public static double calculatePayment(double amount, double interest, double years) {
    double monthlyInterest = interest / 12.0;
    double terms = years * 12.0;
    double monthlyPayment = amount * monthlyInterest
            / (1 - 1 / Math.pow(1 + monthlyInterest, terms));
    return monthlyPayment;
}