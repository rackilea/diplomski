public List<Transactions> getAllTransfersFromAccount(final int cId) {
    /* Create List */
    List<Transactions> transactionsList = new ArrayList<>();
    for(Transactions history : transactionsHistory) {
        if(history.getTransactions() == cId) {
            /* Add Items */
            transactionsList.add(history);
        }
    }
    /* Return List */
    return transactionsList;
}