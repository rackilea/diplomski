import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BoundsInSceneExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox hbox = new HBox();
        Node image = createImage();
        hbox.getChildren().add(image);
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(hbox);

        Scene scene = new Scene(root, 250, 250);

        // force the layout, so layout computations are performed:
        root.layout();

        System.out.printf("Layout coordinates: [%.1f, %.1f]%n", image.getLayoutX(), image.getLayoutY());
        Point2D sceneCoords = image.localToScene(new Point2D(0,0));
        System.out.printf("Scene coordinates: [%.1f, %.1f]%n", sceneCoords.getX(), sceneCoords.getY());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node createImage() {
        Region region = new Region();
        region.setMinSize(128, 128);
        region.setPrefSize(128, 128);
        region.setMaxSize(128, 128);
        region.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        return region ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}