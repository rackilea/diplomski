import javafx.application.Application;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class StarWarsScrollPane extends Application {

    private final String text = "It is a period of civil war. Rebel spaceships, "
            + "striking from a hidden base, have won their first victory against the evil Galactic Empire."
            + " During the battle, Rebel spies managed to steal secret plans to the Empire's ultimate weapon,"
            + " the DEATH STAR, an armored space station with enough power to destroy an entire planet."
            + " Pursued by the Empire's sinister agents, Princess Leia races home aboard her starship,"
            + " custodian of the stolen plans that can save her people and restore freedom to the galaxy....";

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label(text);
        label.setWrapText(true);
        label.setFont(Font.font(18));
        ScrollPane crawler = new ScrollPane(label);
        crawler.setVbarPolicy(ScrollBarPolicy.NEVER);
        crawler.setFitToWidth(true);

        crawler.getTransforms().add(new Rotate(-50, 300, 200, 20, Rotate.X_AXIS));


        Scene scene = new Scene(crawler, 400, 400);
        scene.setCamera(new PerspectiveCamera());


        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}