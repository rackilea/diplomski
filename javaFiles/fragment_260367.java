@Resource
UserTransaction tx;

public void doSomething() {
  tx.setTransactionTimeout(123);
  tx.begin();
  // ...
}