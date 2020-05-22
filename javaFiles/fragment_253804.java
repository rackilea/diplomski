import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Sedrick
 */
public class JavaFXApplication9 extends Application {

    @Override
    public void start(Stage primaryStage) {

        MenuItem menuItem1 = new Menu("One");
        MenuItem menuItem2 = new Menu("Two");

        MenuButton menuButton = new MenuButton();
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("options.png")));
        imageView.setFitWidth(25);
        imageView.setFitHeight(25);
        ImageView imageView2 = new ImageView(new Image(getClass().getResourceAsStream("arrow.png")));
        imageView2.setFitWidth(25);
        imageView2.setFitHeight(15);
        Label label = new Label("Options");
        menuButton.setGraphic(new VBox(new StackPane(imageView), label, new StackPane(imageView2)));
        menuButton.getItems().addAll(menuItem1, menuItem2);
        menuButton.setPopupSide(Side.BOTTOM);

        StackPane root = new StackPane();        
        root.getChildren().add(menuButton);

        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("myCss.css").toString());

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}