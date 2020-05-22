import javafx.animation.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RotatingRectangles extends Application {

    private static final double SCENE_SIZE = 300;
    private static final double EDGE_LENGTH = SCENE_SIZE / 2d;

    private static final Duration ROTATION_DURATION = Duration.seconds(4.5);

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(
            "3D supported? " +
            Platform.isSupported(ConditionalFeature.SCENE3D)
        );

        Scene scene = new Scene(
                createRotatingShapes(),
                SCENE_SIZE, SCENE_SIZE,
                true,
                SceneAntialiasing.BALANCED
        );
        scene.setFill(Color.MIDNIGHTBLUE.darker().darker().darker());
        scene.setCamera(new PerspectiveCamera());

        stage.setScene(scene);
        stage.show();
    }

    private Group createRotatingShapes() {
        final Rectangle rect1 = new Rectangle(
            EDGE_LENGTH, EDGE_LENGTH,
            Color.LIGHTGREEN
        );
        rect1.setTranslateX(-EDGE_LENGTH / 2d);
        rect1.setTranslateY(-EDGE_LENGTH / 2d);
        rect1.setTranslateZ( EDGE_LENGTH / 2d);

        final Rectangle rect2 = new Rectangle(
            EDGE_LENGTH, EDGE_LENGTH,
            Color.DARKGREEN
        );
        rect2.setTranslateX(-EDGE_LENGTH / 2d);
        rect2.setTranslateY(-EDGE_LENGTH / 2d);
        rect2.setTranslateZ(-EDGE_LENGTH / 2d);

        final Group shapes = new Group(
            rect1, rect2
        );

        shapes.setTranslateX(SCENE_SIZE / 2d);
        shapes.setTranslateY(SCENE_SIZE / 2d);
        shapes.setTranslateZ(EDGE_LENGTH / 2d);

        rotateAroundYAxis(shapes);

        return shapes;
    }

    private void rotateAroundYAxis(Node node) {
        RotateTransition rotate = new RotateTransition(ROTATION_DURATION, node);
        rotate.setFromAngle(0);
        rotate.setToAngle(360);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}