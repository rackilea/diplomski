import javafx.application.Application;
import javafx.animation.Timeline ;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration ;

public class ClassApplication extends Application {

    private Pane pane;

    public Parent createContent() {

        /* layout */
        BorderPane layout = new BorderPane();

        /* layout -> center */
        pane = new Pane();
        pane.setMinWidth(250);
        pane.setMaxWidth(250);
        pane.setMinHeight(250);
        pane.setMaxHeight(250);
        pane.setStyle("-fx-background-color: #000000;");

        /* layout -> center -> pane */
        Circle circle = new Circle(125, 125, 10, Color.WHITE);

        /* add items to the layout */
        pane.getChildren().add(circle);

        layout.setCenter(pane);
        return layout;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.setWidth(300);
        stage.setHeight(300);
        stage.show();

        KeyFrame keyFrame = new KeyFrame(Duration.millis(2000), 
            event -> pane.getChildren().setAll(new Circle(50, 50, 10, Color.RED)));
        Timeline timeline = new Timeline(keyFrame);

        // Repeat 10 times:
        timeline.setCycleCount(10);

        timeline.play();
    }

    public static void main(String args[]) {
        launch(args);
    }
}