import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication129 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: green;");
        root.getChildren().add(playerHand());

        Scene scene = new Scene(root, 500, 450);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    HBox playerHand()
    {
        Image image = new Image(getClass().getResourceAsStream("cardBack_blue1.png"));
        ImageView imageView1 = new ImageView(image);
        imageView1.setFitHeight(75);
        imageView1.setFitWidth(50);
        HBox.setMargin(imageView1, new Insets(0, -20, 0, 0));
        imageView1.setOnMouseEntered((event) -> {
            HBox.setMargin(imageView1, new Insets(0, 20, 0, 0));
        });
        imageView1.setOnMouseExited((event) -> {
            HBox.setMargin(imageView1, new Insets(0, -20, 0, 0));
        });
        imageView1.setOnMouseClicked((event) -> {
            System.out.println("Play card!");
        });

        ImageView imageView2 = new ImageView(image);
        imageView2.setFitHeight(75);
        imageView2.setFitWidth(50);
        HBox.setMargin(imageView2, new Insets(0, -20, 0, 0));
        imageView2.setOnMouseEntered((event) -> {
            HBox.setMargin(imageView2, new Insets(30, -20, 0, 0));
        });
        imageView2.setOnMouseExited((event) -> {
            HBox.setMargin(imageView2, new Insets(0, -20, 0, 0));
        });
        imageView2.setOnMouseClicked((event) -> {
            System.out.println("Play card!");
        });

        ImageView imageView3 = new ImageView(image);
        imageView3.setFitHeight(75);
        imageView3.setFitWidth(50);
        HBox.setMargin(imageView3, new Insets(0, -20, 0, 0));
        imageView3.setOnMouseEntered((event) -> {
            HBox.setMargin(imageView3, new Insets(0, 20, 0, 20));
        });
        imageView3.setOnMouseExited((event) -> {
            HBox.setMargin(imageView3, new Insets(0, -20, 0, 0));
        });
        imageView3.setOnMouseClicked((event) -> {
            System.out.println("Play card!");
        });

        ImageView imageView4 = new ImageView(image);
        imageView4.setFitHeight(75);
        imageView4.setFitWidth(50);
        HBox.setMargin(imageView4, new Insets(0, -20, 0, 0));
        imageView4.setOnMouseEntered((event) -> {
            HBox.setMargin(imageView4, new Insets(0, 20, 0, 20));
        });
        imageView4.setOnMouseExited((event) -> {
            HBox.setMargin(imageView4, new Insets(0, -20, 0, 0));
        });
        imageView4.setOnMouseClicked((event) -> {
            System.out.println("Play card!");
        });

        ImageView imageView5 = new ImageView(image);
        imageView5.setFitHeight(75);
        imageView5.setFitWidth(50);
        HBox.setMargin(imageView5, new Insets(0, -20, 0, 0));
        imageView5.setOnMouseEntered((event) -> {
            HBox.setMargin(imageView5, new Insets(30, -20, 0, 0));
        });
        imageView5.setOnMouseExited((event) -> {
            HBox.setMargin(imageView5, new Insets(0, -20, 0, 0));
        });
        imageView5.setOnMouseClicked((event) -> {
            System.out.println("Play card!");
        });

        HBox hBox = new HBox(imageView1, imageView2, imageView3, imageView4, imageView5);
        hBox.setMinSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        hBox.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        hBox.setMaxSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
        //hBox.setStyle("-fx-background-color: red;");
        return hBox;
    }
}