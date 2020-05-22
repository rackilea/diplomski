// Generated proxy class (either via AOP, dynamic proxy or bytecode generation)
@Override
public Token getToken() {
    try {
        transactionManager.startTransaction(params);
        // Only this call is synchronized
        return super.getToken();
    }
    catch (Throwable e) {
        transactionManager.rollback();
        rethrow();
    }
    finally {
        // Not in synchronized method (lock is not held), but changes are not commited yet
        transactionManager.commit();
        transactionManager.closeTransaction();
    }
}