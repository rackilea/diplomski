/* No database. Create if we're allowed to. */
if (dbConfig.getAllowCreate()) {

    /*
     * We're going to have to do some writing. Switch to a
     * writable locker if we don't already have one.  Note
     * that the existing locker does not hold the handle lock
     * we need, since the database was not found; therefore it
     * is OK to call operationEnd on the existing locker.
     */
    if (!isWritableLocker) {
        locker.operationEnd(OperationStatus.SUCCESS);
        locker = LockerFactory.getWritableLocker
            (this,
             txn,
             dbConfig.getTransactional(),
             true,  // retainNonTxnLocks
             autoTxnIsReplicated,
             null);
        isWritableLocker  = true;
    }

    newDb.initNew(this, locker, databaseName, dbConfig);
} else {
    /* We aren't allowed to create this database. */
    throw new DatabaseNotFoundException("Database " +
                                        databaseName +
                                        " not found.");
}