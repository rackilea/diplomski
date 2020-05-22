import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode displayMode = gd.getDisplayMode();

        Canvas canvas = new Canvas(displayMode.getWidth(), displayMode.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Group group = new Group();
        group.getChildren().add(canvas);

        Scene secondScene = new Scene(group, displayMode.getWidth(), displayMode.getHeight());
        secondScene.setFill(Color.TRANSPARENT);         gc.setFill(Color.rgb(0, 0, 0, .5));
        gc.fillRect(0, 0, 100, 100);

        // New window (Stage)
        Stage newWindow = new Stage(StageStyle.UNDECORATED);
        newWindow.initStyle(StageStyle.TRANSPARENT);

        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);

        // Set position of second window, related to primary window.
        newWindow.setX(0);
        newWindow.setY(0);
//      newWindow.setWidth(200);
//      newWindow.setHeight(200);

        newWindow.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}