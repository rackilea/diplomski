public Loan(double annualInterestRate, int numberOfYears,
    double loanAmount) {
    this.annualInterestRate = annualInterestRate;
    this.numberOfYears = numberOfYears;
    this.loanAmount = loanAmount;
    this.loanDate = new Date();
}