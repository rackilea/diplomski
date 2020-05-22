import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @see https://stackoverflow.com/a/38031826/230513
 */
public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test");
        Group group = new Group();
        Scene scene = new Scene(group, 600, 350);
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
        Circle c = new Circle(100, 300, 16, Color.AQUA);
        Line l = new Line(100, 300, 500, 300);
        l.setStroke(Color.AQUA);
        group.getChildren().addAll(c, l);
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        KeyValue xKV = new KeyValue(c.centerXProperty(), 500);
        KeyValue yKV = new KeyValue(c.centerYProperty(), 100, new Interpolator() {
            @Override
            protected double curve(double t) {
                return -4 * (t - .5) * (t - .5) + 1;
            }
        });
        KeyFrame xKF = new KeyFrame(Duration.millis(2000), xKV);
        KeyFrame yKF = new KeyFrame(Duration.millis(2000), yKV);
        timeline.getKeyFrames().addAll(xKF, yKF);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}