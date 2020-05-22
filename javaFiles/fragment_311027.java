import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class HoverableImage extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ImageView imageView = createChestImage();

        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(imageView);

        stage.setScene(new Scene(pane, 100, 100));
        stage.show();
    }

    private ImageView createChestImage() {
        ImageView iv = new ImageView(new Image("https://i.stack.imgur.com/rd71Q.png"));

        iv.setOnMouseEntered(e->{
            iv.setImage(new Image("https://i.stack.imgur.com/7JU7r.png"));
        });

        iv.setOnMouseExited(e->{
            iv.setImage(new Image("https://i.stack.imgur.com/rd71Q.png"));
        });

        return iv;
    }

    public static void main(String[] args) {
        launch(args);
    }

}