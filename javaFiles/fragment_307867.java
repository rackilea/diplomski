import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ImageDisplayTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image image1 = new Image("...") ;
        Image image2 = new Image("...")  ;
        ImageView imageView = new ImageView();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), image1)),
                new KeyFrame(Duration.seconds(3), new KeyValue(imageView.imageProperty(), image2)),
                new KeyFrame(Duration.seconds(8), new KeyValue(imageView.imageProperty(), null))
                );
        timeline.play();
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}