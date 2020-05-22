package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DepartmentEditorApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(
                FXMLLoader.load(
                        getClass().getResource(
                                "department-editor.fxml"
                        )
                )
        );

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}