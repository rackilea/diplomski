public boolean addAccount(String cf, AccountType type) {
    String iban = name + cf;
    if (bankAccounts.containsKey(iban)) return false;
    Account account = type.createAccount(cf, iban, 0);    
    bankAccounts.put(iban, account);
    return true;
}

public enum AccountType {
    CHECKING(CheckingAccount::new),
    DEPOSIT(DepositAccount::new),
    WEB(WebAccount::new);

    private final AccountFactory factory;
    AccountType(AccountFactory factory) {
        this.factory = factory;
    }

    public Account createAccount(String cf, String iban, int x) {
        return factory.create(cf, iban, x);
    }
}

public interface AccountFactory {
    Account create(String cf, String iban, int x);
}