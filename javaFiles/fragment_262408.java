/*
Your use of any portion of the code constitutes your acceptance of full
responsibility for all wonderful and aweful outcomes.
 */
package embedalpha;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BandCombineOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * Demonstrate copying/moving a color band to the alpha band within the same
 * image using only API. The specific method is toAlpha().
 * 
 * @author deskwarrior
 * @see https://stackoverflow.com/questions/47446922/draw-grayscale-image-to-another-bufferedimages-alpha-band-using-api-only
 */
public class TheApp extends Application {
    private final int NODE_SPACING = 5;
    private final int TILE_SIZE = 40;
    private final int APP_WIDTH;
    private final int APP_HEIGHT;

    private final ObjectProperty<BufferedImage> colorSource = new SimpleObjectProperty<>(this, "colorSource", null);
    private final ObjectProperty<BufferedImage> alphaSource = new SimpleObjectProperty<>(this, "alphaSource", null);
    private final Paint backgroundColor;
    private final HBox gallery = new HBox(NODE_SPACING);
    private final IntegerProperty gallerySize = new SimpleIntegerProperty(this, "gallerySize", 0);
    private final Tooltip canvasTip = new Tooltip("Right-click to save image as PNG.");
    private Canvas colorSourceCanvas = null;
    private Canvas alphaSourceCanvas = null;

    private final FileChooser openFC = new FileChooser();
    private final FileChooser saveFC = new FileChooser();
    private File lastDirectoryVisited = null;

    private final RenderingHints colorHints = new RenderingHints(
            RenderingHints.KEY_COLOR_RENDERING, 
            RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    private final ICC_ColorSpace grayColorSpace;
    private final ICC_ColorSpace rgbColorSpace;

    private final BorderPane root = new BorderPane();
    private Stage stage = null;


    public TheApp() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        APP_WIDTH = screenSize.width;
        APP_HEIGHT = screenSize.height * 2 / 3;

        openFC.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp"),
            new FileChooser.ExtensionFilter("All Files", "*.*"));

        saveFC.setTitle("Save image as PNG");
        saveFC.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Portable network graphics", "*.png"));

        colorHints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        ICC_Profile grayProfile = ICC_Profile.getInstance(ColorSpace.CS_GRAY);
        grayColorSpace = new ICC_ColorSpace(grayProfile);
        ICC_Profile rgbProfile = ICC_Profile.getInstance(ColorSpace.CS_sRGB);
        rgbColorSpace = new ICC_ColorSpace(rgbProfile);

        Image tile = createCheckeredTile();
        backgroundColor = new ImagePattern(tile, 0, 0, TILE_SIZE, TILE_SIZE, false);
    }

    /**
     * Convert a BufferedImage to another color space.
     * 
     * @param src cannot be TYPE_CUSTOM or null
     * @param dstImageType valid BufferedImage types: TYPE_BYTE_GRAY, 
     * TYPE_INT_RGB, TYPE_INT_ARGB
     * @return BufferedImage in the new color space. never null.
     * @exception NullPointerException when src is null
     * @exception IllegalArgumentException when dstImageType is not one of the
     * three accepted types
     */
    private BufferedImage toImageType(BufferedImage src, int dstImageType) {
        BufferedImage dst;

        if(src.getType() == dstImageType)
            dst = src;

        else {
            ColorSpace dstColorSpace;

            switch(dstImageType) {
                case BufferedImage.TYPE_BYTE_GRAY:
                    dstColorSpace = grayColorSpace;
                    break;

                case BufferedImage.TYPE_INT_RGB:
                case BufferedImage.TYPE_INT_ARGB:
                    dstColorSpace = rgbColorSpace;
                    break;

                default:
                    String msg = String.format("Conversion to BufferedImage type %d not supported.", dstImageType);
                    throw new IllegalArgumentException(msg);
            }

            /*
            Using ColorConvertOp because the documentation promises images
            with pre-multiplied alphas will be divided out.

            Another possibility is dst.createGraphics().drawImage(src). Whether 
            drawImage() divides out premultiplied alphas is unknown to me, and  
            I don't feel like tracing the method to find out.
             */
            ColorSpace srcColorSpace = src.getColorModel().getColorSpace();
            ColorConvertOp op = new ColorConvertOp(srcColorSpace, dstColorSpace, colorHints);
            dst = new BufferedImage(src.getWidth(), src.getHeight(), dstImageType);
            op.filter(src, dst);
        }

        return dst;
    }

    /**
     * Starting point for merging color source and alpha source into one image.
     * 
     * @param e 
     */
    private void handleBuildComposite(ActionEvent e) {
        try {
            e.consume();

            /*
            Color source's RGB bands will become the composite's RGB bands.
            If color source is ARGB then discard the alpha band to remove
            any premultiplied alpha values.
            If color source is grayscale then convert to RGB in preparation
            for merge.
            */
            final BufferedImage colorSourceRGB = toImageType(getColorSource(), BufferedImage.TYPE_INT_RGB);
            appendGallery(colorSourceRGB, "Color source: RGB");

            /*
            One of alpha source's RGB bands will become the composite's alpha 
            band. 
            If alpha source is a color image, then convert to grayscale to get 
            R == G == B; at the expense of some information. If a color band 
            were copied to the alpha band without conversion, the resulting 
            alpha band wouldn't accurately represent the original color image 
            because R != G != B.
            If alpha source is a grayscale image then no change.
             */
            final BufferedImage alphaSourceGray = toImageType(getAlphaSource(), BufferedImage.TYPE_BYTE_GRAY);
            appendGallery(alphaSourceGray, "Alpha source: grayscale");

            /*
            The objective of this app is to copy/move a color band into the 
            alpha band. Problem is grayscales don't have an alpha band. Convert 
            to ARGB to give it one.
            */
            final BufferedImage alphaRGBA = toImageType(alphaSourceGray, BufferedImage.TYPE_INT_ARGB);
            appendGallery(alphaRGBA, "Alpha source: grayscale to RGBA");

            /*
            Method toAlpha() is where the magic happens. Copy/move one of the 
            color bands into the alpha band.
             */
            final BufferedImage trueAlpha = toAlpha(alphaRGBA);
            appendGallery(trueAlpha, "Alpha source: Green to Alpha, RGB to white");

            /*
            Composite the color values with the alpha values into one image.
            Copy colorSourceRGB's RGB into the composite's RGB. 
            Copy trueAlpha's alpha into the composite's alpha.
            */
            BufferedImage colorPlusAlpha = toComposite(colorSourceRGB, trueAlpha);
            appendGallery(colorPlusAlpha, "Color + alpha composite");
        }

        catch(Exception ex) {
            final Alert dlg = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.CLOSE);
            dlg.showAndWait();
        }
    }

    /**
     * Copy the green band into the alpha band.
     * 
     * @param src presumed to be some type with an alpha band. You're screwed
     * if it isn't.
     * @return a BufferedImage with the green band in the alpha band, and
     * the RGB bands set to white. Never null.
     */
    private BufferedImage toAlpha(BufferedImage src) {
        /*
        This matrix specifies which band(s) to manipulate and how. The 3-ones
        in the right-most column sets dst's RGB bands to white. The solitary
        one in the bottom row will copy the green band into dst's alpha band.

        Footnote: when the grayscale was converted to ARGB I expected the RGB
        bands to be identical. After some testing the bands were found to be
        *near* identical; it seems a color conversion from grayscale to 
        RGB is not as simple as a bulk memory copy. The differences are low 
        enough that no one would've noticed a difference had the either the 
        red or blue band been chosen over the green band.
        */
        final float[][] matrix = new float[][] {
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 1, 0, 0}};

        BandCombineOp op = new BandCombineOp(matrix, null);
        BufferedImage dst = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
        op.filter(src.getRaster(), dst.getRaster());
        return dst;
    }

    /**
     * Composite color's RGB bands with alpha's alpha band into one image.
     * 
     * @param color anything except BufferedImage.TYPE_CUSTOM and null.
     * @param alpha anything with an alpha band otherwise very bad
     * @return a BufferedImage of the two inputs. never null.
     */
    private BufferedImage toComposite(BufferedImage color, BufferedImage alpha) {
        final int width = Math.max(color.getWidth(), alpha.getWidth());
        final int height = Math.max(color.getHeight(), alpha.getHeight());
        final BufferedImage dst = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = dst.createGraphics();
        g.drawImage(color, null, 0, 0);

        /*
        AlphaComposite.DST_IN ignores alpha's RGB bands and copies just the
        alpha band.
        */
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g.drawImage(alpha, null, 0, 0);
        g.dispose();
        return dst;
    }

    private Image createCheckeredTile() {
        final Canvas can = new Canvas(TILE_SIZE, TILE_SIZE);
        final GraphicsContext gc = can.getGraphicsContext2D();
        final int haf = TILE_SIZE / 2;

        gc.setFill(Color.DARKGRAY);
        gc.fillRect(0, 0, haf, haf); // top-left
        gc.fillRect(haf, haf, haf, haf); // bottom-right


        gc.setFill(Color.DIMGREY);
        gc.fillRect(haf, 0, haf, haf); // top-right
        gc.fillRect(0, haf, haf, haf); // bottom-left

        WritableImage snapshot = can.snapshot(null, null);
        return snapshot;
    }

    private void loadImage(String title, ObjectProperty<BufferedImage> imageObj) {
        try {
            openFC.setTitle(title);
            openFC.setInitialDirectory(lastDirectoryVisited);
            File filePath = openFC.showOpenDialog(stage);
            if(filePath != null) {
                lastDirectoryVisited = filePath.getParentFile();
                BufferedImage image = ImageIO.read(filePath);
                imageObj.set(image);
            }
        }

        catch(Exception ex) {
            final Alert dlg = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.CLOSE);
            dlg.showAndWait();
        }
    }

    private void saveImage(MouseEvent e) {
        try {
            if(e.getButton() == MouseButton.SECONDARY) {
                e.consume();
                saveFC.setInitialDirectory(lastDirectoryVisited);
                File filePath = saveFC.showSaveDialog(stage);
                if(filePath != null) {
                    lastDirectoryVisited = filePath.getParentFile();
                    Canvas canvas = (Canvas) e.getSource();
                    BufferedImage img = (BufferedImage) canvas.getUserData();
                    ImageIO.write(img, "png", filePath);
                }
            }
        }

        catch(Exception ex) {
            final Alert dlg = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.CLOSE);
            dlg.showAndWait();
        }
    }

    private Canvas appendGallery(BufferedImage src, String desc) {
        final int width = src.getWidth();
        final int height = src.getHeight();
        final Canvas canvas = new Canvas(width, height);

        canvas.setUserData(src);
        Tooltip.install(canvas, canvasTip);
        canvas.setOnMouseReleased(this::saveImage);

        final GraphicsContext gc = canvas.getGraphicsContext2D();
        final Image image = SwingFXUtils.toFXImage(src, null);
        gc.setFill(backgroundColor);
        gc.fillRect(0, 0, width, height);
        gc.drawImage(image, 0, 0);

        String desc2 = desc != null && !desc.isEmpty() ? desc : "?";
        if(src.isAlphaPremultiplied())
            desc2 += ", premultiplied alpha";
        gc.setStroke(Color.LIME);
        gc.strokeText(desc2, 5, 20);

        gallery.getChildren().add(canvas);
        return canvas;
    }

    private boolean neitherColorNorAlpha(Node n) {
        boolean colorOrAlpha = 
            ((colorSourceCanvas != null) && (n == colorSourceCanvas)) ||
            ((alphaSourceCanvas != null) && (n == alphaSourceCanvas));
        return !colorOrAlpha;
    }

    private void setupMenu() {
        Button loadColorSource = new Button("Load color source ...");
        loadColorSource.setTooltip(new Tooltip("The image's color values will become the composite's color values."));
        loadColorSource.setOnAction((e) -> {
            e.consume();
            loadImage(loadColorSource.getText(), colorSource);
            colorSourceCanvas = appendGallery(getColorSource(), "Color source");
        });

        Button loadAlphaSource = new Button("Load alpha source ...");
        loadAlphaSource.setTooltip(new Tooltip("The image's color values will become the composite's alpha values."));
        loadAlphaSource.setOnAction((e) -> {
            e.consume();
            loadImage(loadAlphaSource.getText(), alphaSource);
            alphaSourceCanvas = appendGallery(getAlphaSource(), "Alpha source");
        });

        Button buildComposite = new Button("Build composite");
        buildComposite.setTooltip(new Tooltip("Merge color and alpha into one image."));
        buildComposite.setOnAction(this::handleBuildComposite);
        buildComposite.disableProperty().bind(colorSource.isNull().or(alphaSource.isNull()));

        Button clearGallery = new Button("Clear gallery");
        clearGallery.setTooltip(new Tooltip("Keep the current color source and alpha source; discard other images."));
        clearGallery.disableProperty().bind(gallerySize.lessThanOrEqualTo(2));
        clearGallery.setOnAction((e) -> {
            e.consume();
            gallery.getChildren().removeIf(this::neitherColorNorAlpha);
        });

        FlowPane parent = new FlowPane(NODE_SPACING, NODE_SPACING);
        parent.setAlignment(Pos.CENTER);
        parent.getChildren().addAll(loadColorSource, loadAlphaSource, buildComposite, clearGallery);
        parent.setPadding(new Insets(NODE_SPACING));
        root.setTop(parent);
    }

    private void setupGallery() {
        gallery.setPadding(new Insets(NODE_SPACING));
        ObservableList<Node> children = gallery.getChildren();
        children.addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                setGallerySize(children.size());
            }
        });
        ScrollPane scroll = new ScrollPane(gallery);
        scroll.setPannable(true);
        scroll.setStyle("-fx-background-color: transparent;");
        root.setCenter(scroll);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        setupMenu();
        setupGallery();

        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);
        stage.setTitle("Embed alpha");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public int getGallerySize() {
        return gallerySize.get();
    }

    public void setGallerySize(int value) {
        gallerySize.set(value);
    }

    public IntegerProperty gallerySizeProperty() {
        return gallerySize;
    }

    public BufferedImage getAlphaSource() {
        return alphaSource.get();
    }

    public void setAlphaSource(BufferedImage value) {
        alphaSource.set(value);
    }

    public ObjectProperty alphaSourceProperty() {
        return alphaSource;
    }

    public BufferedImage getColorSource() {
        return colorSource.get();
    }

    public void setColorSource(BufferedImage value) {
        colorSource.set(value);
    }

    public ObjectProperty colorSourceProperty() {
        return colorSource;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}