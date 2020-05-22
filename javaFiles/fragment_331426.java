public void withdraw(double amount) {
    double bal;
    synchronized(account) {
        bal = account.getBalance();
        if (amount > account.getBalance())
            throw new IllegalArgumentException("wrong amount");
        bal -= amount;
        account.setBalance(bal);
    }
    System.out.println(amount + " withdraw in thread number" + Thread.currentThread().getId() + " balance is " + bal);
}