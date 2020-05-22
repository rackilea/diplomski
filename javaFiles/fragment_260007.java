import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimateXAnchor extends Application {

    @Override
    public void start(Stage primaryStage) {
        Region rect = new Region();
        rect.setPrefSize(100,  100);
        rect.setStyle("-fx-background-color: cornflowerblue;");

        rect.setOnMousePressed(e -> {
            double x = e.getX();
            double y = e.getY();
            System.out.printf("Mouse click in local coordinates: [%.1f, %.1f]%n", x, y);

            Point2D clickInParent = rect.localToParent(x, y);
            System.out.printf("Mouse click in parent coordinates: [%.1f, %.1f]%n%n", clickInParent.getX(), clickInParent.getY());

        });

        AnchorPane root = new AnchorPane();
        root.getChildren().add(rect);
        AnchorPane.setTopAnchor(rect, 10.0);

        DoubleProperty x = new SimpleDoubleProperty();
        x.addListener((obs, oldX, newX) -> AnchorPane.setLeftAnchor(rect, newX.doubleValue()));

        Timeline animation = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(x, 0)),
            new KeyFrame(Duration.seconds(5), new KeyValue(x, 400))
        );

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        animation.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}