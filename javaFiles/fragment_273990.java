import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Just loads the sample GUI
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Layout.fxml"));
            loader.setController(new Controller());

            primaryStage.setScene(new Scene(loader.load()));

            primaryStage.setTitle("Event Source Sample");
            primaryStage.setWidth(300);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}