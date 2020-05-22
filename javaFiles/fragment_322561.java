import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class DragExample extends Application {

    Circle circle_R, circle_G, circle_B;
    WrappedInStackPane wrapped;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    @Override
    public void start(Stage primaryStage) {

        // Create Circles
        circle_R = createCircle( 50, Color.RED, 100, 100);
        circle_G = createCircle( 50, Color.GREEN, 400, 100);
        circle_B = createCircle( 50, Color.BLUE, 700, 100);

        wrapped = new WrappedInStackPane();

        Group root = new Group();
        root.getChildren().addAll(circle_R, circle_G, circle_B, wrapped);

        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(root, 1600, 900));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Circle createCircle( double radius, Color color, double x, double y) {

        Circle circle;

        circle = new Circle(50.0f, color);
        circle.setCursor(Cursor.MOVE);
        circle.setTranslateX(x);
        circle.setTranslateY(y);
        circle.setOnMousePressed(onMousePressedEventHandler);
        circle.setOnMouseDragged(onMouseDraggedEventHandler);

        return circle;
    }
    EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent t) {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX = ((Node) (t.getSource())).getTranslateX();
            orgTranslateY = ((Node) (t.getSource())).getTranslateY();
        }
    };

    EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent t) {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;

            ((Node) (t.getSource())).setTranslateX(newTranslateX);
            ((Node) (t.getSource())).setTranslateY(newTranslateY);
        }
    };

    public class WrappedInStackPane extends StackPane {

        public WrappedInStackPane() {

            setStyle("-fx-background-color: orange;");

            Ellipse ellipse = new Ellipse(100, 50);
            ellipse.setFill(Color.YELLOW);

            Label label = new Label( "Inside StackPane");

            getChildren().addAll(ellipse, label);

            setOnMousePressed(onMousePressedEventHandler);
            setOnMouseDragged(onMouseDraggedEventHandler);

            relocate(200, 200);

        }
    }
}