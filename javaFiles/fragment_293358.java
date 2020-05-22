import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class DrawPolygon extends Application {

    private Polygon currentPolygon ;

    @Override
    public void start(Stage primaryStage) {
        Pane rootPane = new Pane();
        rootPane.setMinSize(600, 600);
        rootPane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                if (currentPolygon == null) {
                    currentPolygon = new Polygon();
                    currentPolygon.setStroke(Color.BLACK);
                    rootPane.getChildren().add(currentPolygon);
                }
                currentPolygon.getPoints().addAll(e.getX(), e.getY());
            } else {
                currentPolygon = null ;
            }
        });
        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}