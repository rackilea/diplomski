import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageTransformTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        ImageView arrow = new ImageView(createImage());
        Pane pane = new Pane(arrow);
        pane.setMinSize(600,  600);

        new Dragger(arrow) ;
        arrow.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                arrow.setRotate(arrow.getRotate() + 90);
            }
        });

        Scene scene = new Scene(pane) ;
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class Dragger {
        private double x ;
        private double y ;
        Dragger(ImageView imageView) {
            imageView.setOnMousePressed(e -> {
                x = e.getSceneX();
                y = e.getSceneY();
            });
            imageView.setOnMouseDragged(e -> {
                double deltaX = e.getSceneX() - x ;
                double deltaY = e.getSceneY() - y ;
                imageView.setX(imageView.getX() + deltaX);
                imageView.setY(imageView.getY() + deltaY);
                x = e.getSceneX() ;
                y = e.getSceneY() ;
            });
        }
    }

    private Image createImage() {
        WritableImage image = new WritableImage(100, 100);
        for (int y = 0 ; y < 40 ; y++) {
            for (int x = 0 ; x < 50 - 50 * y / 40 ; x++) {
                image.getPixelWriter().setColor(x, y, Color.TRANSPARENT);
            }
            for (int x = 50 - 50 * y / 40 ; x < 50 + 50 * y / 40 ; x ++) {
                image.getPixelWriter().setColor(x, y, Color.BLUE);
            }
            for (int x = 50 + 50 * y ; x < 100 ; x++) {
                image.getPixelWriter().setColor(x, y, Color.TRANSPARENT);
            }
        }
        for (int y = 40 ; y < 100 ; y++) {
            for (int x = 0 ; x < 100 ; x++) {
                image.getPixelWriter().setColor(x, y, x < 30 || x > 70 ? Color.TRANSPARENT : Color.BLUE);
            }
        }

        return image ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}