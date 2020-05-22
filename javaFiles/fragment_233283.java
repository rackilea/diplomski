import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class XRayVision extends Application {
    private static final int TOLERANCE_THRESHOLD = 0xFF;
    private static final String BACKGROUND_IMAGE_LOC = 
            "http://imgs.abduzeedo.com/files/articles/20_beautiful_landscape_wallpapers/landscape-wallpaper-1.jpg";
    private static final String ORIGINAL_IMAGE_LOC = 
            "http://dab1nmslvvntp.cloudfront.net/wp-content/uploads/2011/01/toy.jpg";

    private Image makeTransparent(Image inputImage) {
        int W = (int) inputImage.getWidth();
        int H = (int) inputImage.getHeight();
        WritableImage outputImage = new WritableImage(W, H);
        PixelReader reader = inputImage.getPixelReader();
        PixelWriter writer = outputImage.getPixelWriter();
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                int argb = reader.getArgb(x, y);

                int r = (argb >> 16) & 0xFF;
                int g = (argb >> 8) & 0xFF;
                int b = argb & 0xFF;

                if (r >= TOLERANCE_THRESHOLD 
                        && g >= TOLERANCE_THRESHOLD 
                        && b >= TOLERANCE_THRESHOLD) {
                    argb &= 0x00FFFFFF;
                }

                writer.setArgb(x, y, argb);
            }
        }

        return outputImage;
    }

    @Override
    public void start(final Stage stage) throws Exception {
        final Image backgroundImage = new Image(BACKGROUND_IMAGE_LOC);
        final ImageView backgroundImageView = new ImageView(backgroundImage);
        final Image originalImage = new Image(ORIGINAL_IMAGE_LOC);
        final ImageView originalImageView = new ImageView(originalImage);
        final Image resampledImage = makeTransparent(originalImage);
        final ImageView resampledImageView = new ImageView(resampledImage);

        final HBox images = new HBox(originalImageView, resampledImageView);
        stage.getIcons().add(originalImage);

        final StackPane layout = new StackPane(backgroundImageView, images);
        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}