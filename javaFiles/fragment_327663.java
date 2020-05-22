import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class TestApplication extends Application {
    private Stage stage;
    private Scene scene, scene2;

    public void start(Stage s) {
        scene = new Scene(new Group(new Label("1")), 200, 150);
        scene2 = new Scene(new Group(new Label("2")), 200, 150);

        scene.setFill(Color.GREEN);
        scene2.setFill(Color.ORANGE);

        scene.setOnMouseClicked(e -> changeScene(scene2));
        scene2.setOnMouseClicked(e -> changeScene(scene));

        stage = s;
        s.setScene(scene);
        s.show();
    }

    private void changeScene(Scene nex) {
        stage.setScene(nex);
    }

    public static void main(String[] args) {
        launch(args);
    }
}