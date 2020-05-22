import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageViewDragExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image image = createImage();
        DraggableImageView imageView = new DraggableImageView(image);

        // if the node is placed in a parent that manages its child nodes,
        // you must call setManaged(false);

//      imageView.setManaged(false);
//      StackPane root = new StackPane(imageView);

        // or use a plain `Pane`, which does not manage its child nodes:
        Pane root = new Pane(imageView);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Image createImage() {
        WritableImage image = new WritableImage(50, 50);
        for (int y = 0 ; y < 50; y++) {
            for (int x = 0 ; x < 50 ; x++) {
                Color c ;
                if ((x > 20 && x < 30) || (y > 20 && y < 30)) {
                    c = Color.AZURE ;
                } else {
                    c = Color.CORNFLOWERBLUE ;
                }
                image.getPixelWriter().setColor(x, y, c);
            }
        }
        return image ;
    }

    public static class DraggableImageView extends ImageView {
        private double mouseX ;
        private double mouseY ;
        public DraggableImageView(Image image) {
            super(image);

            setOnMousePressed(event -> {
                mouseX = event.getSceneX() ;
                mouseY = event.getSceneY() ;
            });

            setOnMouseDragged(event -> {
               double deltaX = event.getSceneX() - mouseX ;
               double deltaY = event.getSceneY() - mouseY ;
               relocate(getLayoutX() + deltaX, getLayoutY() + deltaY);
               mouseX = event.getSceneX() ;
               mouseY = event.getSceneY() ;
            });
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}