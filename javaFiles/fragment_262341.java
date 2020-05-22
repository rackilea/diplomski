import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Java2 extends Application {

    public static final int PANEL_WIDTH = 600;
    public static final int PANEL_HEIGHT = 600;

    Random ran = new Random();

    @Override
    public void start(Stage primaryStage) {

        Rectangle rekt = new Rectangle(20, 20);

        Pane root = new Pane();

        root.getChildren().add(rekt);

        Scene scene = new Scene(root, PANEL_WIDTH, PANEL_HEIGHT);

        PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(javafx.util.Duration.millis(500));
        pathTransition.setPath(createPath());
        pathTransition.setNode(rekt);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(2);
        pathTransition.setAutoReverse(true);
        pathTransition.setOnFinished(e -> {

            pathTransition.setPath(createPath());
            pathTransition.play();

        });
        pathTransition.play();

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Path createPath() {

        int loc = ran.nextInt(600 - 300 + 1) + 300; // min=300 , max=600

        Path path = new Path();

        path.getElements().add(new MoveTo(20, 20));
        path.getElements().add(new LineTo(loc, 600));

        return path;

    }

    public static void main(String[] args) {
        launch(args);
    }

}