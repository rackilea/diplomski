import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class CirclesAroundCircle extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        double centerX = 300 ;
        double centerY = 300 ;
        double earthRadius = 30 ;
        double moonRadius = 30 ;

        Circle earth = new Circle(centerX, centerY, earthRadius, Color.web("blue", 0.5));
        pane.getChildren().add(earth);

        int numMoons = 3 ;
        double gap = 10 ;
        double distance = 100 ;
        double angleIncrement = 2 * Math.asin((2 * moonRadius + gap) / (2  * distance) );

        for (int i = 0 ; i < numMoons; i++) {

            double angle = Math.toDegrees(angleIncrement * i) ;

            Circle moon = new Circle(centerX + distance, centerY, moonRadius, Color.web("blue", 0.5));
            Rotate rotate = new Rotate(angle, centerX, centerY);
            moon.getTransforms().add(rotate);
            pane.getChildren().add(moon);
        }

        Circle orbit = new Circle(centerX, centerY, distance, Color.TRANSPARENT);
        orbit.setStroke(Color.BLACK);
        pane.getChildren().add(orbit);

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}