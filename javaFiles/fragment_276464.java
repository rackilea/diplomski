import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AxisTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        NumberAxis leftAxis = new NumberAxis(0, 100, 10);
        leftAxis.setSide(Side.LEFT);

        NumberAxis bottomAxis = new NumberAxis(0, 100, 10);


        GridPane root = new GridPane();
        Pane center = new Pane();
        center.setPrefSize(600, 600);
        root.add(center, 1, 0);
        root.add(leftAxis, 0, 0);
        root.add(bottomAxis, 1, 1);

        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}