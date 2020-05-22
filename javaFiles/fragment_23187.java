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

        try {
            // Load the main layout
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainLayout.fxml"));

            // Show the Stage
            primaryStage.setWidth(700);
            primaryStage.setHeight(500);
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}