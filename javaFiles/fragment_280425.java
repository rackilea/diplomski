try {
    propagateCtx = false;
    term.commit(true);
    propagateCtx = true;
} catch (TransactionRolledbackException e) {
    Current.getCurrent().forgetTx(getXid());
    if (TraceTm.jta.isDebugEnabled()) {
        TraceTm.jta.debug("Commit distributed transaction -> rolled back!");
    }
    localstatus = Status.STATUS_ROLLEDBACK;
    throw new RollbackException();
} 
...