public interface Saveable <T> {
    void save(T entity);
}

public class AccountSaver implements Saveable<Account> {
    void save(Account account){
        // ... save account
    }
}

public class CustomerSaver implements Saveable<Customer> {
    void save(Customer customer){
        // ... save customer
    }
}

public class TransactionSaver implements Saveable<Transaction> {
    void save(Transaction transaction){
        // ... save transaction
    }
}