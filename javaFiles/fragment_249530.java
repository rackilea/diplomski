package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.root.RootPane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new RootPane(), 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}