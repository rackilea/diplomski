import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class SceneSetter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList("Single", "Double", "Suite", "Family App");
        list.setItems(items);

        list.getSelectionModel().select(0);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                list.requestFocus();
            }
        });

        mainStage.setScene(new Scene(list));
        // or here 
        // list.requestFocus();
        mainStage.show();
    }

}