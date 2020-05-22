public interface Transaction {

    void begin();

    void commit();

    void rollback();

    TransactionStatus getStatus();

    void registerSynchronization(Synchronization synchronization) throws HibernateException;

    void setTimeout(int seconds);

    int getTimeout();

    void markRollbackOnly();

 }