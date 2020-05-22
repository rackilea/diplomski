import java.util.stream.Stream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DragToCanvas extends Application {

    private Color draggingColor ;

    @Override
    public void start(Stage primaryStage) {
        Pane dragFromPane = new Pane();
        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.ANTIQUEWHITE);
        gc.fillRect(0, 0, 600, 600);

        Label coordinateLabel = new Label("[ ]");
        coordinateLabel.setStyle("-fx-font-size: 24;");

        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.BLACK} ;
        for (int i = 0;  i < colors.length; i++) {
            drawCircle(colors[i], dragFromPane, i);
        }

        canvas.setOnDragOver(e -> {
            if (draggingColor != null 
                    && e.getDragboard().hasString() 
                    && e.getDragboard().getString().equals("circle")) {
                e.acceptTransferModes(TransferMode.COPY);
            }
            coordinateLabel.setText(String.format("[%.1f, %.1f]", e.getX(), e.getY()));
        });

        canvas.setOnDragDropped(e -> {
            if (e.getDragboard().hasString() 
                    && e.getDragboard().getString().equals("circle")) {
                gc.setFill(draggingColor);
                gc.fillOval(e.getX()-25, e.getY()-25, 50, 50);
                draggingColor = null ;
                e.setDropCompleted(true);
            }
        });

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setLeft(dragFromPane);
        root.setBottom(coordinateLabel);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawCircle(Color c, Pane dragFromPane, int index) {
        Circle circle = new Circle(60, 60*(index+1), 25);
        circle.setFill(c);
        dragFromPane.getChildren().add(circle);
        circle.setOnDragDetected(e -> {
            Dragboard db = circle.startDragAndDrop(TransferMode.COPY);
            db.setDragView(circle.snapshot(null, null));
            ClipboardContent cc = new ClipboardContent();
            cc.putString("circle");
            db.setContent(cc);
            draggingColor = c ;
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}