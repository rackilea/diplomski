import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication357 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        List<Color> colors = Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PURPLE);
        AtomicInteger counter = new AtomicInteger(0);
        Circle circle = new Circle(200, Color.TRANSPARENT);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(300), (event) -> {
            circle.setFill(colors.get(counter.getAndIncrement() % colors.size()));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Button btn = new Button();
        btn.setText("Stop");
        btn.setOnAction((ActionEvent event) -> {
            timeline.stop();
        });

        VBox root = new VBox(new StackPane(circle), new StackPane(btn));

        Scene scene = new Scene(root, 450, 450);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}