private void setTransactionContext(Timestamp ts) {
  if (this.transactionContext == null) {
    this.transactionContext = new ThreadLocal<>();
  }
  this.transactionContext.set(ts);
}