import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CommitmentApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    private Parent createContent() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        return loader.load(
            getClass().getResourceAsStream("commit.fxml")
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}