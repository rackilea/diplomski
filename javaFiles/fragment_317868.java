import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControllerCurrencyAdd {

    @FXML
    private TextField TF_name;
    @FXML
    private TextField TF_value;
    @FXML
    private TextField TF_acronym;

    @FXML
    void add(ActionEvent event) {
        Currency currency = new Currency(TF_name.getText(), Double.valueOf(TF_value.getText()));

        // since we update the list used as the table's backing list, the table will automatically update:
        Datas.getInstance().addCurrency(currency);

    }
}