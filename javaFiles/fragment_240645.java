public class ExampleUnitTest {
    @Test
    public void testSample() throws Exception {
        TransactionDatabase transactionDatabase = new TransactionDatabase();

        transactionDatabase.insert(new Transaction(1, 50.00, new Date()));
        transactionDatabase.insert(new Transaction(2, 20.00, new Date()));
        transactionDatabase.insert(new Transaction(3, 110.00, new Date()));
        transactionDatabase.insert(new Transaction(4, 250.00, new Date()));
        transactionDatabase.insert(new Transaction(5, 5.00, new Date()));
        transactionDatabase.insert(new Transaction(5, 73.00, new Date()));

        List<Func1<Transaction, Boolean>> filters = new ArrayList<>();

        filters.add(transaction -> transaction.transactionAmount > 20);
        filters.add(transaction -> transaction.transactionAmount < 100);

        transactionDatabase.getTransactions(filters)
                .subscribe(System.out::println);
    }

    private class Transaction {
        int transactionId;
        double transactionAmount;
        Date transactionDate;

        public Transaction(int transactionId, double transactionAmount, Date transactionDate) {
            this.transactionId = transactionId;
            this.transactionAmount = transactionAmount;
            this.transactionDate = transactionDate;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "transactionId=" + transactionId +
                    ", transactionAmount=" + transactionAmount +
                    ", transactionDate=" + transactionDate +
                    '}';
        }
    }

    class TransactionDatabase {
        List<Transaction> transactions = new ArrayList<>();

        public void insert(Transaction transaction) {
            transactions.add(transaction);
        }

        public Observable<Transaction> getTransactions(List<Func1<Transaction, Boolean>> filters) {
            Observable<Transaction> observable = Observable.from(transactions);

            for (Func1<Transaction, Boolean> filter : filters) {
                observable = observable.filter(filter);
            }

            return observable;
        }
    }
}