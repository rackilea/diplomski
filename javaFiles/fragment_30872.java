import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage s) {
        ImageView image = new ImageView(new Image("img.png"));

        ColorAdjust darker = new ColorAdjust();
        darker.setBrightness(-.3);

        image.setOnMouseEntered(e-> {
            image.setEffect(darker);
        });

        image.setOnMouseExited(e-> {
            image.setEffect(null);
        });

        s.setScene(new Scene(new StackPane(image)));
        s.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}