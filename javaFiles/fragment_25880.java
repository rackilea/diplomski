private final ObservableList<Account> accounts = FXCollections.observableArrayList();

public ObservableList<Account> accounts() { return accounts; }

@XmlElementWrapper(name="accounts")
@XmlElement(name = "account")
public List<Account> getAccounts() {
    return new ArrayList<>(accounts);
}

public void setAccounts(List<Account> accounts) {
    this.accounts.setAll(accounts);
}