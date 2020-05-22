import java.nio.file.Paths;
import java.util.List;

import javafx.application.Application;

import javafx.beans.Observable;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;

import javafx.stage.Stage;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;

import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;

public class ImageDragExample
extends Application {
    private static final String DEFAULT_IMAGE =
        "http://solarsystem.nasa.gov/images/galleries/618486main_earth_320.jpg";

    private GridPane grid;

    private ImageView preview;
    private ImageView dragImage;
    private Pane dragPane;
    private Rectangle dragPaneClip;

    private Point2D dragStart;
    private Node dragTarget;
    private Shape dragHighlight;

    @Override
    public void start(Stage stage) {
        grid = new GridPane();
        grid.setHgap(24);
        grid.setVgap(24);
        grid.setPadding(new Insets(12));
        int id = 0;
        for (int row = 0; row < 3; row++) {
            Node p1 = createPlaceholder(String.valueOf(row * 4 + 1));
            Node p2 = createPlaceholder(String.valueOf(row * 4 + 2));
            Node p3 = createPlaceholder(String.valueOf(row * 4 + 3));
            Node p4 = createPlaceholder(String.valueOf(row * 4 + 4));
            grid.addRow(row, p1, p2, p3, p4);
        }

        List<String> args = getParameters().getRaw();
        preview = new ImageView(args.isEmpty() ? DEFAULT_IMAGE :
            Paths.get(args.get(0)).toUri().toString());

        BorderPane imageArea = new BorderPane(preview);
        imageArea.setPadding(new Insets(12));

        Region contents = new BorderPane(new SplitPane(grid, imageArea));

        dragImage = new ImageView();
        dragImage.imageProperty().bind(preview.imageProperty());
        dragImage.setFocusTraversable(true);
        dragImage.setOpacity(0);
        dragImage.setOnMousePressed(e -> startDrag(e));
        dragImage.setOnMouseDragged(e -> updateDrag(e));
        dragImage.setOnMouseReleased(e -> endDrag(e));
        dragImage.setOnKeyPressed(e -> rotate(e));

        dragPane = new AnchorPane(dragImage);
        dragPaneClip = new Rectangle();
        dragPane.setClip(dragPaneClip);
        StackPane pane = new StackPane(contents, dragPane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);

        preview.boundsInParentProperty().addListener(this::placeDragImage);
        imageArea.boundsInParentProperty().addListener(this::placeDragImage);
        stage.widthProperty().addListener(this::placeDragImage);
        stage.heightProperty().addListener(this::placeDragImage);
        placeDragImage(null);

        stage.setTitle("Image Drag Example");
        stage.show();
    }

    private void rotate(KeyEvent e){
        System.out.println(e.getCode() + " pressed");
    }

    private void startDrag(MouseEvent event){
        dragStart = new Point2D(event.getScreenX(), event.getScreenY());
        dragImage.setOpacity(0.5);
        dragImage.requestFocus();
        dragPane.setClip(null);
    }

    private void updateDrag(MouseEvent event){
        double x = event.getScreenX();
        double y = event.getScreenY();
        double xDelta = x - dragStart.getX();
        double yDelta = y - dragStart.getY();
        dragImage.setTranslateX(xDelta);
        dragImage.setTranslateY(yDelta);

        Node newDragTarget = null;
        for (Node node : grid.getChildren()) {
            if (node.contains(node.screenToLocal(x, y))) {
                newDragTarget = node;
                break;
            }
        }

        removeDragHighlight();
        dragTarget = newDragTarget;
        addDragHighlight(dragTarget);
    }

    private void endDrag(MouseEvent event){
        if (dragTarget != null) {
            removeDragHighlight();
            System.out.println("Dropped on " + dragTarget.getId());
        }

        dragImage.setOpacity(0);
        dragImage.setTranslateX(0);
        dragImage.setTranslateY(0);
        dragPane.setClip(dragPaneClip);
        dragStart = null;
        dragTarget = null;
    }

    private void placeDragImage(Observable o) {
        if (preview.getScene() != null && dragImage.getScene() != null) {
            Point2D point = preview.localToScene(0, 0);
            if (point != null) {
                point = dragImage.getParent().sceneToLocal(point);
                AnchorPane.setLeftAnchor(dragImage, point.getX());
                AnchorPane.setTopAnchor(dragImage, point.getY());
                dragPaneClip.setX(point.getX());
                dragPaneClip.setY(point.getY());
                dragPaneClip.setWidth(dragImage.getLayoutBounds().getWidth());
                dragPaneClip.setHeight(dragImage.getLayoutBounds().getHeight());
            }
        }
    }

    private void addDragHighlight(Node node) {
        if (node != null) {
            Bounds bounds = node.getBoundsInLocal();

            dragHighlight = null;
            if (node instanceof Region) {
                dragHighlight = ((Region) node).getShape();
            }
            if (dragHighlight == null) {
                dragHighlight = new Rectangle(
                    bounds.getMinX(), bounds.getMinY(),
                    bounds.getWidth(), bounds.getHeight());
            } else {
                // Clone the node's shape by subtracting an empty shape from it.
                dragHighlight = Shape.subtract(dragHighlight, new Polyline());
            }
            dragHighlight.setStrokeWidth(2);
            dragHighlight.setStroke(Color.RED);
            dragHighlight.setFill(null);

            bounds = dragHighlight.getBoundsInLocal();
            Point2D shapeOrigin = 
                node.localToScene(bounds.getMinX(), bounds.getMinY());
            shapeOrigin = dragPane.sceneToLocal(shapeOrigin);

            dragPane.getChildren().add(dragHighlight);
            AnchorPane.setLeftAnchor(dragHighlight, shapeOrigin.getX());
            AnchorPane.setTopAnchor(dragHighlight, shapeOrigin.getY());
        }
    }

    private void removeDragHighlight() {
        if (dragHighlight != null) {
            dragPane.getChildren().remove(dragHighlight);
            dragHighlight = null;
        }
    }

    private Node createPlaceholder(String id) {
        Label label = new Label(id);
        label.setId(id);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-background-color: #c0c0ff;");
        label.setPrefSize(200, 200);
        return label;
    }
}