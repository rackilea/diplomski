import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Datas {

    // SINGLETON PATTERN
    private Datas() {
    }

    private static Datas INSTANCE = new Datas();

    public static Datas getInstance() {
        return INSTANCE;
    }
    // END SINGLETON PATTERN

    // VARS
    private ObservableList<Currency> currencies = FXCollections.observableArrayList();

    // FUNCTIONS - Add/Edit/Delete
    public void addCurrency(Currency currency) {
        currencies.add(currency);
    }

    // FUNCTIONS - getter/setters
    public ObservableList<Currency> getCurrencies() {
        return currencies;
    }

}