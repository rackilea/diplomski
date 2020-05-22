import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StyledTextArea extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(
            FXMLLoader.load(getClass().getResource("StyledTextArea.fxml"))
        ));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}