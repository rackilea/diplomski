private TransactionTemplate transactionTemplate;

public setTransactionManager(PlatformTransactionManager transactionManager) {
  this.transactionTemplate = new TransactionTemplate(transactionManager);
}

...

while (true) {

  transactionTemplate.execute(new TransactionCallbackWithoutResult() {
    protected void doInTransactionWithoutResult(TransactionStatus status) {
      try {
        dao.m1(data1);
        dao.m2(data2);
        dao.m3(data3);
        dao.m4(data4);
      } catch(DbUpdateException e) {
        status.setRollbackOnly();
      }
    }
  });
}