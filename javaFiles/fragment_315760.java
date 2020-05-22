import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RotateGroupKeepTextAligned extends Application {   

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        StackPane container = new StackPane();
        Group outer = new Group();
        Rectangle outerRect = new Rectangle(0, 0, 400, 400);
        outerRect.setFill(Color.ANTIQUEWHITE);
        outer.getChildren().add(outerRect);

        Text outerText = new Text(5,  5, "Outer Group");
        Group inner = new Group();
        inner.relocate(10, 25);
        Text innerText = new Text(5, 5, "Inner Group");
        Rectangle rect = new Rectangle(50, 50, 150, 150);
        rect.setFill(Color.CORNFLOWERBLUE);
        Text fixedAlignmentText = new Text(100, 220, "Horizontal Text");

        inner.localToSceneTransformProperty().addListener((obs, oldT, newT) -> {
            // figure overall rotation angle of inner:
            Point2D leftScene = newT.transform(new Point2D(0, 0));
            Point2D rightScene = newT.transform(new Point2D(1, 0));

            double angle = Math.toDegrees(Math.atan2(rightScene.getY() - leftScene.getY(), rightScene.getX() - leftScene.getX()));

            fixedAlignmentText.setRotate(-angle);
        });

        outer.setStyle("-fx-background-color: antiquewhite;");
        outer.getChildren().addAll(outerText, inner);

        inner.setStyle("-fx-background-color: white;");
        inner.getChildren().addAll(innerText, rect, fixedAlignmentText);

        container.getChildren().add(outer);
        root.setCenter(container);

        VBox controls = new VBox(5,
                makeControls("Outer Group", outer),
                makeControls("Inner Group", inner));

        root.setBottom(controls);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node makeControls(String title, Node node) {
        GridPane grid = new GridPane();

        Label label = new Label(title);
        Spinner<Double> rotateSpinner = new Spinner<>(0, 360, 0, 5);
        node.rotateProperty().bind(rotateSpinner.getValueFactory().valueProperty());
        rotateSpinner.getValueFactory().setWrapAround(true);

        Button up = createTranslateButton(node, Node::translateYProperty, -2, "^");
        Button down = createTranslateButton(node, Node::translateYProperty, 2, "v");
        Button left = createTranslateButton(node, Node::translateXProperty, -2, "<");
        Button right = createTranslateButton(node, Node::translateXProperty, 2, ">");

        grid.add(label, 0, 0, 3, 1);
        grid.add(new Label("Rotation:"), 0, 1, 1 ,2);
        grid.add(rotateSpinner, 1, 1, 1, 2);
        grid.add(up, 3, 1);
        grid.add(down, 3, 2);
        grid.add(left, 2, 1, 1, 2);
        grid.add(right, 4, 1, 1, 2);

        grid.setHgap(5);
        grid.setVgap(5);

        return grid ;
    }

    private Button createTranslateButton(Node node, Function<Node, DoubleProperty> property, double delta, String text) {
        Button button = new Button(text);
        button.setOnAction(e -> {
            DoubleProperty prop = property.apply(node);
            prop.set(prop.get() + delta);
        });
        return button ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}