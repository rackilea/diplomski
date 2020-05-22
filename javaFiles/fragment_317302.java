import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication241 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        BorderPane root = new BorderPane();

        GridPane centerRoot = new GridPane();
        centerRoot.setAlignment(Pos.CENTER);
        GridPane.setMargin(centerRoot, new Insets(50, 50, 50, 50));
        root.setCenter(centerRoot);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        for (int i = 0; i < 10; i++) {
            for (int t = 0; t < 10; t++) {
                Image image = new Image("https://s3.amazonaws.com/media.eremedia.com/uploads/2012/08/24111405/stackoverflow-logo-700x467.png");
                ImageView imageView = new ImageView(image);
                imageView.fitHeightProperty().bind(centerRoot.heightProperty().subtract(100).divide(10));
                imageView.fitWidthProperty().bind(centerRoot.widthProperty().subtract(100).divide(10));
                imageView.setPreserveRatio(false);
                centerRoot.add(imageView, i, t);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}