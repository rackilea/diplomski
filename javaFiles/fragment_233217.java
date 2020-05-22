public void transfer(Account acc1, Account acc2, BigDecimal value) {
    Object lock1 = acc1.ID < acc2.ID ? acc1.LOCK : acc2.LOCK;
    Object lock2 = acc1.ID < acc2.ID ? acc2.LOCK : acc1.LOCK;
    synchronized (lock1) {
       synchronized (lock2) {
          acc1.widrawal(value);
          acc2.send(value);
       }
    }
}