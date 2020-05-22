import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class NeighborhoodDrive extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Create a pane to hold the group
        Pane pane = new Pane();

        House house = new House(175, 75 ,pane);

        //Create handler for moving cars
        EventHandler<ActionEvent> eventHandler = e ->
        {

        };
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(25), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        //Create a scene and place it in the stage
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Neighborhood Drive"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}