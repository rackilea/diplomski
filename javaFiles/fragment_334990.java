import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class ArrowTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        double startx = 200;
        double starty = 100;
        double endx = 100;
        double endy = 300;

        double arrowAngle = Math.toRadians(45.0);
        double arrowLength = 10.0;

        double lineAngle = Math.atan2(starty - endy, startx - endx);

        double x1 = Math.cos(lineAngle + arrowAngle) * arrowLength + endx;
        double y1 = Math.sin(lineAngle + arrowAngle) * arrowLength + endy;

        double x2 = Math.cos(lineAngle - arrowAngle) * arrowLength + endx;
        double y2 = Math.sin(lineAngle - arrowAngle) * arrowLength + endy;

        Group root = new Group();

        Line line = new Line(startx, starty, endx, endy);
        Line arrowHead1 = new Line(endx, endy, x1, y1);
        Line arrowHead2 = new Line(endx, endy, x2, y2);

        root.getChildren().addAll(line, arrowHead1, arrowHead2);

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}