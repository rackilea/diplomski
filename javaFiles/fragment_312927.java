public void doSomething() {
    startTransaction();
    try {
        orgBean.doSomething();
        commitTransaction();
    }
    catch (RuntimeException e) {
        rollbackTransaction();
        throw e;
    }
}