transactionTemplate.execute(new TransactionCallbackWithoutResult() {

  protected void doInTransactionWithoutResult(TransactionStatus status) {
    try {
      updateOperation1();this is your updateDB1()
      updateOperation2();-->this is your updateDB2()
    } catch (SomeBusinessExeption ex) {
      status.setRollbackOnly();
    }
  }
});