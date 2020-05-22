try {
    userTransaction.begin();
    executeSomeBusinessCode();
    userTransaction.commit();
}
catch (RuntimeException e) {
    userTransaction.rollback();
}