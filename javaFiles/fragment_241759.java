import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImageClickExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        ImageView img = new ImageView("http://i.stack.imgur.com/oURrw.png");
        img.setPickOnBounds(true); // allows click on transparent areas
        img.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Clicked!"); // change functionality
        });
        Scene scene = new Scene(new StackPane(img));
        primaryStage.setTitle("Image Click Example");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}