import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RotatingCube extends Application {

    private static final double SCENE_SIZE = 300;
    private static final double BOX_EDGE_LENGTH = SCENE_SIZE / 2d;

    private static final Color BOX_COLOR     = Color.DARKGREEN;
    private static final Color AMBIENT_COLOR = Color.rgb(30, 30, 30);
    private static final Color LIGHT_COLOR   = Color.WHITE;

    private static final Duration ROTATION_DURATION = Duration.seconds(4.5);

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(
                new Group(
                        new AmbientLight(AMBIENT_COLOR),
                        createPointLight(),
                        createRotatingBox()
                ),
                SCENE_SIZE, SCENE_SIZE,
                true,
                SceneAntialiasing.BALANCED
        );
        scene.setFill(Color.MIDNIGHTBLUE.darker().darker().darker());
        scene.setCamera(new PerspectiveCamera());

        stage.setScene(scene);
        stage.show();
    }

    private PointLight createPointLight() {
        PointLight light = new PointLight(LIGHT_COLOR);
        light.setTranslateX( SCENE_SIZE / 2d);
        light.setTranslateY( SCENE_SIZE / 2d);
        light.setTranslateZ(-SCENE_SIZE);

        return light;
    }

    private Box createRotatingBox() {
        final Box box = new Box(BOX_EDGE_LENGTH, BOX_EDGE_LENGTH, BOX_EDGE_LENGTH);
        box.setTranslateX(SCENE_SIZE / 2d);
        box.setTranslateY(SCENE_SIZE / 2d);
        box.setTranslateZ(BOX_EDGE_LENGTH / 2d);
        box.setMaterial(new PhongMaterial(BOX_COLOR));

        rotateAroundYAxis(box);

        return box;
    }

    private void rotateAroundYAxis(Box box) {
        RotateTransition rotate = new RotateTransition(ROTATION_DURATION, box);
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