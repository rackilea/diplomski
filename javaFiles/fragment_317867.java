import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerOptions implements Initializable {
    // VARIABLES
    @FXML
    private TableView<Currency> TV_currency;
    @FXML
    private TableColumn<Currency, String> TC_name;
    @FXML
    private TableColumn<Currency, Double> TC_value;

    private ObservableList<Currency> currencies = FXCollections.observableArrayList();

    // FUNCTIONS
    @Override
    public void initialize(URL location, ResourceBundle rb) {
        // initialisation Table Currencies

        TC_name.setCellValueFactory(new PropertyValueFactory<Currency, String>("name"));
        TC_value.setCellValueFactory(new PropertyValueFactory<Currency, Double>("value"));

        // Note how the list from Datas is used directly in the table:
        TV_currency.setItems(Datas.getInstance().getCurrencies()); 
    }

    @FXML
    void add_currency(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("options/currency_add.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Add new currency");
        stage.setScene(new Scene(root1));
        stage.setFullScreen(true);
        stage.show();
    }

    @FXML
    void open_options(ActionEvent event) throws IOException {
        Group actor = new Group();
        actor.getChildren().add(FXMLLoader.load(getClass().getResource("options.fxml")));
        Main.setScene(actor, "Where's My Money");
    }
}