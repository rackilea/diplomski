package decorationtest;

import javafx.application.Application;
import javafx.stage.StageStyle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DecorationTest extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.UNDECORATED);

        Group root = new Group();
        Scene scene = new Scene(root, 100, 100);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}