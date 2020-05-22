@Transactional
public void doIt() {
    boolean stayIntransaction = true;
    while (stayInTransaction) {
        Event event = readTcp()
        doWork(event);
        stayInTransaction = transactionDone(event);
    }
}