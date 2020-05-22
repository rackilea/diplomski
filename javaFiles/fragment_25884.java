import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.UUID;

public class Account {
    private final StringProperty id;
    private final IntegerProperty balance;

    public Account() {
        this(UUID.randomUUID().toString(), 0);
    }

    public Account(int balance) {
        this(UUID.randomUUID().toString(), balance);
    }

    public Account(String id, int balance) {
        this.id = new SimpleStringProperty(id);
        this.balance = new SimpleIntegerProperty(balance);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
    }

    public int getBalance() {
        return balance.get();
    }

    public IntegerProperty balanceProperty() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance.set(balance);
    }
}