public boolean withdraw(double amount) {
    if (amount <= 0.0) {
        System.out.println("Withdrawal amount should be positive!");
        return false;
    }

    double fee = (amount > balance) ? overdraftFee : 0.0;
    setBalance(balance - amount - fee);
    return true;
}