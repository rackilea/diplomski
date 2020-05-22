public static void main(String[] args) {
    BankAccount<String> bankAccount = new BankAccount<>();
    bankAccount.addTransaction(Double.toString(2.00), TransactionType.DEPOSIT);
    bankAccount.addTransaction(Double.toString(100.66), TransactionType.DEPOSIT);
    bankAccount.addTransaction(Double.toString(2.00), TransactionType.WITHDRAW);
    bankAccount.addTransaction("ERROR", TransactionType.WITHDRAW);

    List<Transaction<String>> transactions = bankAccount.getTransactions();

    List<Transaction<String>> collect = transactions.stream()
            .filter(tr -> !tr.getAmount().equals("ERROR"))
            .sorted(Comparator.<Transaction<String>, String> comparing(transaction -> transaction.getAmount()).reversed())
            .collect(Collectors.toList());

    collect.forEach(tr -> System.out.println(tr.getAmount() + " " + tr.getType().name()));
}

public static class BankAccount<T> {

    private List<Transaction<T>> transactions = new ArrayList<>();

    public void addTransaction(T amount, TransactionType transactionType) {
        Transaction<T> transaction = new Transaction <>(amount, transactionType);
        transactions.add(transaction);
    }

    public List<Transaction<T>> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}

public static class Transaction<T> {
    private final T amount;
    private final TransactionType transactionType;
    private final Date dateCreated;

    public Transaction(T amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.dateCreated = new Date();
    }

    public T getAmount() {
        return amount;
    }

    public TransactionType getType(){
        return transactionType;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

}

public enum TransactionType {
    DEPOSIT, WITHDRAW;
}