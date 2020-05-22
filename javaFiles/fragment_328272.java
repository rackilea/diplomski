kafkaTemplate.executeInTransaction(t -> {
    boolean stayIntransaction = true;
    while (stayInTransaction) {
        Event event = readTcp()
        doWork(event);
        stayInTransaction = transactionDone(event);
    }
}