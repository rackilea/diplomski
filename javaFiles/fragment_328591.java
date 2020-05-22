import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.*;

public class ScreenSizeImage extends Application {
    @Override public void start(final Stage stage) {
        // uncomment if you want the stage full screen.
        //stage.setFullScreen(true);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());

        StackPane root = new StackPane();
        root.setStyle(
            "-fx-background-image: url(" +
                "'http://icons.iconarchive.com/icons/iconka/meow/256/cat-box-icon.png'" +
            "); " +
            "-fx-background-size: cover;"
        );
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}