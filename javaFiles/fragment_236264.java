import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ShadowSpray extends Application {
    private static final double W = 400;
    private static final double H = 400;
    private static final int SHADOW_LENGTH = 100;

    private static final double IMG_X = 20;
    private static final double IMG_Y = 20;

    private static final int FONT_SIZE = 200;

    private static final double SHADOW_SLOPE_FACTOR = 1.5;

    Color SHADOW_COLOR = Color.GRAY.brighter();

    @Override
    public void start(Stage stage) {
        Image image = getImage();

        Canvas canvas = new Canvas(W, H);
        GraphicsContext gc = canvas.getGraphicsContext2D();
//        drawWithShadowUsingStencil(gc, image, IMG_X, IMG_Y, SHADOW_LENGTH, SHADOW_COLOR);
        drawWithShadowUsingColorAdjust(gc, image, IMG_X, IMG_Y, SHADOW_LENGTH);

        stage.setScene(new Scene(new Group(canvas)));
        stage.show();
    }

    private void drawWithShadowUsingColorAdjust(GraphicsContext gc, Image image, double x, double y, int shadowLength) {
        // here the color adjust for the shadow is based upon the intensity of the input image color
        // which is a weird way to calculate a shadow color, but does come out nicely
        // because it appropriately handles antialiased input images.
        ColorAdjust monochrome = new ColorAdjust();
        monochrome.setBrightness(+0.5);
        monochrome.setSaturation(-1.0);

        gc.setEffect(monochrome);

        for (int offset = shadowLength; offset > 0; --offset) {
            gc.drawImage(image, x + offset, y + offset / SHADOW_SLOPE_FACTOR);
        }

        gc.setEffect(null);

        gc.drawImage(image, x, y);
    }

    private void drawWithShadowUsingStencil(GraphicsContext gc, Image image, double x, double y, int shadowLength, Color shadowColor) {
        Image shadow = createShadowImage(image, shadowColor);

        for (int offset = shadowLength; offset > 0; --offset) {
            gc.drawImage(shadow, x + offset, y + offset / SHADOW_SLOPE_FACTOR);
        }

        gc.drawImage(image, x, y);
    }


    private Image createShadowImage(Image image, Color shadowColor) {
        WritableImage shadow = new WritableImage(image.getPixelReader(), (int) image.getWidth(), (int) image.getHeight());
        PixelReader reader = shadow.getPixelReader();
        PixelWriter writer = shadow.getPixelWriter();
        for (int ix = 0; ix < image.getWidth(); ix++) {
            for (int iy = 0; iy < image.getHeight(); iy++) {
                int argb = reader.getArgb(ix, iy);
                int a = (argb >> 24) & 0xFF;
                int r = (argb >> 16) & 0xFF;
                int g = (argb >>  8) & 0xFF;
                int b =  argb        & 0xFF;

                // because we use a binary choice, we lose anti-alising info in the shadow so it looks a bit jaggy.
                Color fill = (r > 0 || g > 0 || b > 0) ? shadowColor : Color.TRANSPARENT;

                writer.setColor(ix, iy, fill);
            }
        }
        return shadow;
    }

    private Image getImage() {
        Label label = new Label("a");
        label.setStyle("-fx-text-fill: forestgreen; -fx-background-color: transparent; -fx-font-size: " + FONT_SIZE + "px;");
        Scene scene = new Scene(label, Color.TRANSPARENT);
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        return label.snapshot(snapshotParameters, null);
    }

    public static void main(String[] args) {
        launch();
    }
}