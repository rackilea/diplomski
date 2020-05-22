public void withdraw(double amount) throws NegativeAmountException,
                                           InsufficientFundsException {
    if (amount > balance ) {
        throw new NegativeAmountException();
    }
    if (amount > balance ) {
        throw new InsufficientFundsException();
    }
    balance -= amount;
}