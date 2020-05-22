import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.*;
import java.util.Random;

public class FindNearest extends Application {
    private static final int N_SHAPES = 10;
    private static final double W = 600, H = 400;

    private ShapeMachine machine;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws MalformedURLException, URISyntaxException {
        double maxShapeSize = W / 8;
        double minShapeSize = maxShapeSize / 2;
        machine = new ShapeMachine(W, H, maxShapeSize, minShapeSize);
    }

    @Override
    public void start(final Stage stage) throws IOException, URISyntaxException {
        Pane pane = new Pane();
        pane.setPrefSize(W, H);
        for (int i = 0; i < N_SHAPES; i++) {
            pane.getChildren().add(machine.randomShape());
        }

        pane.setOnMouseClicked(event -> {
            Node node = findNearestNode(pane.getChildren(), event.getX(), event.getY());
            highlightSelected(node, pane.getChildren());
        });

        Scene scene = new Scene(pane);
        configureExitOnAnyKey(stage, scene);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void highlightSelected(Node selected, ObservableList<Node> children) {
        for (Node node: children) {
           node.setEffect(null);
        }

        if (selected != null) {
            selected.setEffect(new DropShadow(10, Color.YELLOW));
        }
    }

    private Node findNearestNode(ObservableList<Node> nodes, double x, double y) {
        Point2D pClick = new Point2D(x, y);
        Node nearestNode = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (Node node : nodes) {
            Bounds bounds = node.getBoundsInParent();
            Point2D[] corners = new Point2D[] {
                    new Point2D(bounds.getMinX(), bounds.getMinY()),
                    new Point2D(bounds.getMaxX(), bounds.getMinY()),
                    new Point2D(bounds.getMaxX(), bounds.getMaxY()),
                    new Point2D(bounds.getMinX(), bounds.getMaxY()),
            };

            for (Point2D pCompare: corners) {
                double nextDist = pClick.distance(pCompare);
                if (nextDist < closestDistance) {
                    closestDistance = nextDist;
                    nearestNode = node;
                }
            }
        }

        return nearestNode;
    }

    private void configureExitOnAnyKey(final Stage stage, Scene scene) {
        scene.setOnKeyPressed(keyEvent -> stage.hide());
    }
}