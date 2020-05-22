import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    int count = 1;

    @Override
    public void start(Stage stage) {

        StackPane root = new StackPane();
        Scene s = new Scene(root, 400, 400, Color.BLACK);

        final Canvas canvas = new Canvas(300, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        gc.fillRect(10, 10, 300, 300);

        ImageView image = new ImageView("https://cdn0.iconfinder.com/data/icons/toys/256/teddy_bear_toy_6.png");

        // Listener for MouseClick
        image.setOnMouseClicked(e -> {
            Stage popup = new Stage();
            popup.initOwner(stage);
            popup.show();
        });

        root.getChildren().addAll(canvas, image);

        stage.setScene(s);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}