package populatetable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AppMainController implements Initializable {

    @FXML
    private TableView<Data> tvData;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    private ObservableList<Data> tvObservableList = FXCollections.observableArrayList();

    // Open dialog button click event
    @FXML
    void onOpenDialog(ActionEvent event) throws IOException {
        System.out.println("onOpenDialog clicked");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dialog.fxml"));
        Parent parent = fxmlLoader.load();
        DialogController dialogController = fxmlLoader.<DialogController>getController();
        dialogController.setAppMainObservableList(tvObservableList);
        Scene scene = new Scene(parent, 300, 200);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tvData.setItems(tvObservableList);

    }

    public ObservableList<Data> getTvObservableList() {
        return tvObservableList;
    }


}