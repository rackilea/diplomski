synchronized(bank-lock) {
    int totalDollars = countAllMoneyInGame(...);
    if (totalDollars != 15140) {
        throw new CheatingDetectedException(...);
    }
}