class Account {
    private double balance;             // make variable private

    // write synchronized accessor methods
    public synchronized void setBalance(double b) {
        balance = b;
    }

    public synchronized double getBalance() {
        return balance;
    }

    // modify update method to use accessor methods
    synchronized void updateBalance(double amount) {
    //    double b = getBalance();
        setBalance( getBalance() + amount);
    }
}