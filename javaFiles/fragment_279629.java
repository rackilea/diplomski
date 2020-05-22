import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.DepthTest;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StarWarsCrawler extends Application {

    private final String text = "It is a period of civil war. Rebel spaceships, "
            + "striking from a hidden base, have won their first victory against the evil Galactic Empire.\n\n"
            + "During the battle, Rebel spies managed to steal secret plans to the Empire's ultimate weapon,"
            + " the DEATH STAR, an armored space station with enough power to destroy an entire planet.\n\n"
            + "Pursued by the Empire's sinister agents, Princess Leia races home aboard her starship,"
            + " custodian of the stolen plans that can save her people and restore freedom to the galaxy....";

    @Override
    public void start(Stage primaryStage) {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();
        int width = (int) primaryScreenBounds.getWidth() ;
        int height = (int) primaryScreenBounds.getHeight() ;

        Text textNode = createText(width);

        Translate translate = new Translate();
        textNode.getTransforms().add(new Rotate(-60, 300, height/2, height/30, Rotate.X_AXIS));
        textNode.getTransforms().add(translate);

        Timeline animation = new Timeline(
                new KeyFrame(Duration.seconds(45), new KeyValue(translate.yProperty(), -10*height))
        );
        textNode.setTranslateY(2*height);

        StackPane root = new StackPane();

        generateStarField(width, height, root);

        root.getChildren().add(textNode);

        Scene scene = createScene(root);

        primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();

        animation.play();
        animation.setOnFinished(e -> Platform.exit());
    }

    private Scene createScene(StackPane root) {
        Scene scene = new Scene(root, Color.BLACK);
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setDepthTest(DepthTest.ENABLE);
        scene.setCamera(camera);
        scene.setCursor(Cursor.NONE);
        scene.setOnMouseClicked(e -> {
            if (e.getClickCount() ==2) {
                Platform.exit();
            }
        });
        return scene;
    }

    private Text createText(int width) {
        Text textNode = new Text(text);
        textNode.setWrappingWidth(width*1.25);
        textNode.setFont(Font.font("Franklin Gothic", width/12));
        textNode.setFill(Color.rgb(229, 177, 58));
        return textNode;
    }

    private void generateStarField(int width, int height, StackPane root) {
        int numStars = width * height / 900 ;

        Random rng = new Random();
        for (int i = 1 ; i <= numStars ; i++) {
            double hue = rng.nextDouble() * 360 ;
            double saturation = rng.nextDouble() * 0.1 ;
            Color color = Color.hsb(hue, saturation, 1.0);
            Circle circle = new Circle(rng.nextInt(width), rng.nextInt(height), 2*rng.nextDouble(), color);
            circle.setManaged(false);
            circle.setTranslateZ(rng.nextDouble() * height * 1.25);
            root.getChildren().add(circle);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}