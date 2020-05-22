private synchronized void setBalance(int newBalance) {
    this.balance = newBalance;
}

private synchronized int getBalance() {
    return this.balance;
}