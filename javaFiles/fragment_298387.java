public Account() {
    this(0, 0d, 0d);
}  

public Account(int id, double balance, double interestRate) {
    this.id = id;
    this.balance = balance;
    this.annualInterestRate = interestRate;
}   

public PreferredCustomer(int id, double balance) {
    super(id, balance, 0.04d);
}