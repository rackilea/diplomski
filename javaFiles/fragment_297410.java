import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MyController {

    @FXML
    private ListView<String> userListView;

    @FXML
    public void initialize() {

        ObservableList<String> items = FXCollections.observableArrayList("Single", "Double", "Suite", "Family App");
        userListView.setItems(items);
        userListView.getSelectionModel().select(0);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                userListView.requestFocus();
            }
        });
    }
}