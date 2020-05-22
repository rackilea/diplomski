import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LayersWithMouseEvents extends Application {

    @Override
    public void start(Stage primaryStage) {

        // root
        StackPane root = new StackPane();

        // create layers
        Pane region1Layer = new Pane();
        Pane region2Layer = new Pane();

        // add layers
        root.getChildren().addAll(region1Layer, region2Layer);

        // load images
        ImageView region1ImageView = new ImageView( new Image( getClass().getResource("region1.png").toExternalForm()));
        ImageView region2ImageView = new ImageView( new Image( getClass().getResource("region2.png").toExternalForm()));

        // add images
        region1Layer.getChildren().add(region1ImageView);
        region2Layer.getChildren().add(region2ImageView);

        // mouse handler
        region1Layer.setOnMousePressed(e -> System.out.println("Region 1: " + e));
        region2Layer.setOnMousePressed(e -> System.out.println("Region 2: " + e));

        // this is the magic that allows you to click on the separate layers, but ONLY(!) as long as the layer is transparent
        region1Layer.setPickOnBounds(false);
        region2Layer.setPickOnBounds(false);

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}