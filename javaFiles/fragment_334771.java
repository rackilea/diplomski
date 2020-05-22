import java.util.ArrayList;
import java.util.Random;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameBoard extends StackPane {

    private final int TILE_WIDTH = 60;
    private final int TILE_HEIGHT = 60;

    private final int WIDTH;
    private final int HEIGHT;

    private int rows;
    private int columns;

    private ArrayList<Image> tileImages = new ArrayList<Image>();

    private final Pane gamePane = new Pane();

    public GameBoard() {
        this(9, 9);
    }

    public GameBoard(int rows, int columns) {

        this.rows = rows;
        this.columns = columns;

        WIDTH = columns * TILE_WIDTH;
        HEIGHT = rows * TILE_HEIGHT;

        // set the Clipping
        clipChildren(gamePane);

        // set the background color and also fix the dimensions 
        gamePane.setStyle("-fx-background-color : #52033D");
        gamePane.setMinSize(WIDTH, HEIGHT);
        gamePane.setPrefSize(WIDTH, HEIGHT);
        gamePane.setMaxSize(WIDTH, HEIGHT);
        getChildren().add(gamePane);

        initTilesImages();
        fillTiles();
    }

    public void clipChildren(Region region) {
        final Rectangle clipPane = new Rectangle();
        region.setClip(clipPane);

        // In case we want to make a resizable pane we need to update
        // our clipPane dimensions
        region.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            clipPane.setWidth(newValue.getWidth());
            clipPane.setHeight(newValue.getHeight());
        });
    }

    public void restartGame() {
        gamePane.getChildren().clear();
        fillTiles();
    }

    private void initTilesImages() {
        tileImages.add(new Image(this.getClass().getResource("/resources/redTile.png").toExternalForm()));
        tileImages.add(new Image(this.getClass().getResource("/resources/greenTile.png").toExternalForm()));
        tileImages.add(new Image(this.getClass().getResource("/resources/blueTile.png").toExternalForm()));
        tileImages.add(new Image(this.getClass().getResource("/resources/purpleTile.png").toExternalForm()));
        tileImages.add(new Image(this.getClass().getResource("/resources/whiteTile.png").toExternalForm()));
        tileImages.add(new Image(this.getClass().getResource("/resources/yellowTile.png").toExternalForm()));
    }

    // Fill with random images
    private void fillTiles() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ImageView tile = createTile(j, i);
                gamePane.getChildren().add(tile);
            }
        }
    }

    // Create the ImageView which I call "tile"
    private ImageView createTile(int x, int y) {
        Random rand = new Random();

        int index = rand.nextInt(tileImages.size());
        ImageView img = new ImageView(tileImages.get(index));

        img.setFitWidth(TILE_WIDTH);
        img.setFitHeight(TILE_HEIGHT);

        img.setTranslateX(x * TILE_WIDTH);

        // set some rotation and transition

        RotateTransition rt = new RotateTransition(Duration.millis(2000));
        rt.setFromAngle(0);
        rt.setToAngle(360);



TranslateTransition tt = new TranslateTransition(Duration.millis(2000));
    tt.setFromY(TILE_HEIGHT * (y - rows));
    tt.setToY(y * TILE_HEIGHT);
    tt.play();

    ParallelTransition pt = new ParallelTransition(img, tt, rt);
    pt.play();

    return img;
}