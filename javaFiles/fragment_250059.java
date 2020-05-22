import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: Black");
        Pane graph = new Pane();
        root.setCenter(graph);
        // graph.setLayoutX(250);
        // graph.setLayoutY(250);

        Circle circle = new Circle(250, 250, 5);
        circle.setFill(Color.ORANGE);
        graph.getChildren().add(circle);

        Circle circle2 = new Circle(250, 250, 5);
        circle2.setFill(Color.AQUA);
        graph.getChildren().add(circle2);

        TranslateTransition t = new TranslateTransition(Duration.millis(1000), circle);
        t.setFromX(0);
        t.setToX(100);
        t.setFromY(0);
        t.setToY(0);

        t.setInterpolator(Interpolator.LINEAR);
        t.play();

        stage.setTitle("Circle Test");
        stage.setScene((new Scene(root, 500, 500)));
        stage.show();
    }
}