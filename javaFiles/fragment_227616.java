import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ImageViewTest extends Application   {

public static void main(String[] args) {
  launch(args);
}

@Override
public void start(Stage stage) throws Exception {

    ResizableCanvas rc = new ResizableCanvas();
    rc.setOnMouseEntered(e -> {
        System.out.println("entered ");
    });
    Image image = new Image("rushmore.png");

    ImageView imageView = new ImageView();
    imageView.setImage(image);
    imageView.setSmooth(true);
    imageView.setCache(true);


    AnchorPane rootAnchorPane = new AnchorPane();
    AnchorPane resizableCanvasAnchorPane = new AnchorPane();


   rc.widthProperty().bind(resizableCanvasAnchorPane.widthProperty());
 rc.heightProperty().bind(resizableCanvasAnchorPane.heightProperty());


    imageView.fitWidthProperty().bind(stage.widthProperty());
    imageView.fitHeightProperty().bind(stage.heightProperty());
    imageView.setPreserveRatio(true);

    //here's where the 'magic happens'
    resizableCanvasAnchorPane.getChildren().addAll(imageView, rc);
    rootAnchorPane.getChildren().addAll(resizableCanvasAnchorPane,rc);

    Scene scene = new Scene(rootAnchorPane);
    scene.setFill(Color.BLACK);
    stage.setTitle("ImageView Test");
    stage.setWidth(415);
    stage.setHeight(200);
    stage.setScene(scene);
    stage.show(); 
   }

}