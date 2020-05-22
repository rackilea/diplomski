import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage myStage;

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();

        // this creates a instance of Controller now
        // and not a instance of Main
        Parent root = (Parent) loader.load(getClass().getResourceAsStream("load.fxml"));

        // get the controller corresponding to root
        Controller controller = loader.getController();

        // tell the controller that this is it's Main class
        controller.setMain(this);

        stage.setTitle("FXML Welcome");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();

        myStage = stage;
    }

    public void handleLoadButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        myStage.setTitle("FXML Main");
        myStage.setScene(new Scene(root, 300, 275));
        myStage.show();
    }
}