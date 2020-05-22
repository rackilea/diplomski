import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Main extends Application {
      public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 50, 100);
        stage.setScene(scene);

        Group g = new Group();

        Polygon polygon1 = new Polygon();
        polygon1.getPoints().addAll(new Double[]{
            0.0, 0.0,
            25.0, 25.0,
            50.0, 0.0 });
        polygon1.setFill(javafx.scene.paint.Color.GREEN);

        Polygon polygon2 = new Polygon();
        polygon2.getPoints().addAll(new Double[]{
            0.0, 0.0,
            25.0, 25.0,
            0.0, 50.0 });
        polygon2.setFill(javafx.scene.paint.Color.YELLOW);

        Polygon polygon3 = new Polygon();
        polygon3.getPoints().addAll(new Double[]{
            50.0, 50.0,
            25.0, 25.0,
            0.0, 50.0 });
        polygon3.setFill(javafx.scene.paint.Color.BLUE);

        Polygon polygon4 = new Polygon();
        polygon4.getPoints().addAll(new Double[]{
           50.0, 0.0,
           25.0, 25.0,
           50.0, 50.0 });
        polygon4.setFill(javafx.scene.paint.Color.RED);

        g.getChildren().addAll(polygon1, polygon2, polygon3, polygon4);

        scene.setRoot(g);
        stage.show();
      }

      public static void main(String[] args) {
        launch(args);
      }
    }