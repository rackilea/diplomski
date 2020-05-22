import static java.lang.Math.cos;
import static java.lang.Math.sin;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RotatingCircles extends Application {
    public static final double CIRCLES_CENTER_X = 600;
    public static final double CIRCLES_CENTER_Y = 450;
    public static final double CIRCLES_RADIUS = 15;
    public static final double CIRCLES_DISTANCE = 300;
    public static final double GAME_HEIGHT = 700;
    public static final double GAME_WIDTH = 1200; 

    private Stage primaryStage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setMinWidth(GAME_WIDTH);
        primaryStage.setMinHeight(GAME_HEIGHT);
                    final Scene scene;
        BorderPane root = new BorderPane();
        scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT); 

        Circle orangeCircle = new Circle(CIRCLES_CENTER_X + CIRCLES_DISTANCE / 2 * cos(0),
                CIRCLES_CENTER_Y + CIRCLES_DISTANCE / 2 * sin(0),
                CIRCLES_RADIUS, Color.ORANGE);
        Circle yellowCircle = new Circle(CIRCLES_CENTER_X - CIRCLES_DISTANCE / 2 * cos(0),
                CIRCLES_CENTER_Y - CIRCLES_DISTANCE / 2 * sin(0),
                CIRCLES_RADIUS, Color.YELLOW);

        Pane game = new Pane(orangeCircle, yellowCircle); 
        root.setCenter(game);

        Rotate orangeCircleRotation = new Rotate(0, CIRCLES_CENTER_X, CIRCLES_CENTER_Y);
        orangeCircle.getTransforms().add(orangeCircleRotation);
        Rotate yellowCircleRotation = new Rotate(0, CIRCLES_CENTER_X, CIRCLES_CENTER_Y);
        yellowCircle.getTransforms().add(yellowCircleRotation);
        Timeline rotationAnimation = new Timeline();
        rotationAnimation.setCycleCount(Timeline.INDEFINITE);
        rotationAnimation.getKeyFrames().add(new KeyFrame(Duration.seconds(2), new KeyValue(orangeCircleRotation.angleProperty(), 360)));
        rotationAnimation.getKeyFrames().add(new KeyFrame(Duration.seconds(2), new KeyValue(yellowCircleRotation.angleProperty(), 360)));

        root.setOnKeyPressed(ke -> {
           if (ke.getCode() == KeyCode.RIGHT) {
               rotationAnimation.play();
               rotationAnimation.setRate(1);
           } else if (ke.getCode() == KeyCode.LEFT) {
               rotationAnimation.play();
               rotationAnimation.setRate(-1);
           }
        });
        root.setOnKeyReleased(ke -> {
            rotationAnimation.pause();
        });


        primaryStage.setScene(scene);
        primaryStage.show();

        root.requestFocus();
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }
}