public class TransactionsManager {
    private final List<Transaction> transactionsList;

    public TransactionsManager(List<Transaction> transactionsList) {
        this.transactionsList = Collections.unmodifiableList(transactionsList);
    }

    public List<Transaction> findByBankName(String bankName) {
        return transactionsList.stream()
                .filter(t -> t.getAccount().getNameBank().contains(bankName))
                .collect(Collectors.toList());
    }
}