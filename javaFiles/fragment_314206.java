import javafx.application.Application;
import javafx.animation.PauseTransition ;
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

        PauseTransition pause = new PauseTransition(Duration.millis(2000));
        pause.setOnFinished(event -> pane.getChildren().setAll(new Circle(50, 50, 10, Color.RED)));
        pause.play();
    }

    public static void main(String args[]) {
        launch(args);
    }
}