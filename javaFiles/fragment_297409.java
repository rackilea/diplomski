import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class SceneSetter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        ListView<String> list = FXMLLoader.load(this.getClass().getResource("GUI.fxml"));

        mainStage.setScene(new Scene(list));

        mainStage.show();
    }

}