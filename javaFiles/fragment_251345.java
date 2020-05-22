package myapp.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DialogDisplayApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "add-dialog.fxml"
                )
        );

        stage.setScene(new Scene(new VBox(new Label("Main Window")), 600, 400));
        stage.show();

        Dialog dialog = loader.load();
        dialog.getDialogPane().getButtonTypes().addAll(
                ButtonType.CLOSE
        );

        dialog.initOwner(stage);
        dialog.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}