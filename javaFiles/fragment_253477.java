import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingCat extends Application {    
    private static final double WIDTH = 100;
    private static final double HEIGHT = 100;
    private final String ARROW_PATH =
            "http://icons.iconarchive.com/icons/iconka/meow-2/64/cat-rascal-icon.png";
            // image source: http://www.iconka.com

    @Override
    public void start(Stage stage) {
        Image image = new Image(ARROW_PATH);
        ImageView imageView = new ImageView(image);
        TranslateTransition animation = new TranslateTransition(
                Duration.seconds(0.7), imageView
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setFromY(0);
        animation.setToY(50);
        animation.setAutoReverse(true);

        Pane pane = new Pane(imageView);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        scene.setOnMouseClicked(e -> {
            switch (e.getButton()) {
                case PRIMARY:
                    animation.play();
                    break;

                case SECONDARY:
                    animation.pause();
                    break;
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}