interface IMonetaryTransaction {
    // This...
    IMonetaryTransaction getParentBillingTransaction();

    // ...rather than this
    long getParentBillingTransactionId();
}