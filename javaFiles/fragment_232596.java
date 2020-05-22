import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class CommitController {

    @FXML
    private TableView<Singular> table;

    @FXML
    private TableColumn<Singular, String> value;

    @FXML
    void commitValue(TableColumn.CellEditEvent<Singular, String> event) {
        System.out.println("Commit: " + event.getNewValue());
    }

    public void initialize() {
        value.setCellFactory(TextFieldTableCell.forTableColumn());
        value.setCellValueFactory(new PropertyValueFactory<>("value"));
        value.setEditable(true);

        table.getItems().setAll(
                new Singular("enie"),
                new Singular("meenie"),
                new Singular("minie"),
                new Singular("moe"),
                new Singular("just commit!")
        );
        table.setEditable(true);
    }

    public static class Singular {
        private StringProperty value = new SimpleStringProperty();

        public Singular(String value) {
            this.value.setValue(value);
        }

        public StringProperty valueProperty() {
            return value;
        }
    }
}