import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int SIDE = 40;
    private static final double DEFAULT_WIDTH = 200;
    private static final double DEFAULT_POSITION = 100;

    @Override
    public void start(Stage primaryStage) {

        Rectangle rectangle = new Rectangle(SIDE, SIDE);
        HBox root = new HBox(rectangle);
        root.setPrefWidth(DEFAULT_WIDTH);

        rectangle.translateXProperty().bind(root.widthProperty().multiply(DEFAULT_POSITION/DEFAULT_WIDTH).subtract(SIDE/2));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}